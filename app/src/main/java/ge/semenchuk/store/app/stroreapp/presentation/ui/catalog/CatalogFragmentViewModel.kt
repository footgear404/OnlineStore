package ge.semenchuk.store.app.stroreapp.presentation.ui.catalog

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.GetFavoritesUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.GetItemsFromApiUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.RemoveFromFavoriteUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.SaveFavoriteUseCase
import ge.semenchuk.store.app.stroreapp.domain.utils.Constants
import ge.semenchuk.store.app.stroreapp.domain.utils.support.SortCriteria
import ge.semenchuk.store.app.stroreapp.domain.utils.support.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CatalogFragmentViewModel(
    private val getItemsFromApiUseCase: GetItemsFromApiUseCase,
    private val saveFavoriteUseCase: SaveFavoriteUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val removeFromFavoriteUseCase: RemoveFromFavoriteUseCase,
) : ViewModel() {
    private var _state = MutableStateFlow<State>(State.Await)
    private var _items = MutableStateFlow<List<ItemDto>>(emptyList())

    val state = _state.asStateFlow()
    val items = _items.asStateFlow()


    val favorite: Flow<List<ItemDto>> = getFavoritesUseCase.execute()

    init {
        viewModelScope.launch {
            _state.value = State.Loading
            _items.value = getItemsFromApiUseCase.execute()
            if (_items.value.isNotEmpty()) {
                _state.value = State.Success
                return@launch
            }
            _state.value = State.Error("Что-то пошло не так")
        }
    }

    fun addToFavorite(itemDto: ItemDto) {
        val item = _items.value.find { it.id == itemDto.id }
        item?.let {
            it.isFavorite = !itemDto.isFavorite
            viewModelScope.launch(Dispatchers.IO) {
                if (it.isFavorite) {
                    saveFavoriteUseCase.add(it)
                } else {
                    removeFromFavoriteUseCase.delete(it)
                }
            }
        }
    }

    fun sort(by: SortCriteria) {
        when (by) {
            SortCriteria.BY_RATE -> {
                Log.d(Constants.Log.SORT, by.name)
                _items.value = items.value.sortedByDescending { it.feedbackDto?.rating }
            }

            SortCriteria.BY_PRICE_ASC -> {
                Log.d(Constants.Log.SORT, by.name)
                _items.value = items.value.sortedBy { it.priceDto?.priceWithDiscount }
            }

            SortCriteria.BY_PRICE_DESC -> {
                Log.d(Constants.Log.SORT, by.name)
                _items.value = items.value.sortedByDescending { it.priceDto?.priceWithDiscount }
            }
        }
    }
}