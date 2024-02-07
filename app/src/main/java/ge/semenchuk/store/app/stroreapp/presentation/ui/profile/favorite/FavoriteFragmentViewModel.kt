package ge.semenchuk.store.app.stroreapp.presentation.ui.profile.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.GetFavoritesUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.RemoveFromFavoriteUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.SaveFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoriteFragmentViewModel(
    getFavoritesUseCase: GetFavoritesUseCase,
    private val saveFavoriteUseCase: SaveFavoriteUseCase,
    private val removeFromFavoriteUseCase: RemoveFromFavoriteUseCase,
) : ViewModel() {
    private var _items = MutableStateFlow<List<ItemDto>>(emptyList())
    val items = _items.asStateFlow()

    val favorite: Flow<List<ItemDto>> = getFavoritesUseCase.execute()


    fun removeFromFavorite(itemDto: ItemDto) {
        viewModelScope.launch(Dispatchers.IO) { removeFromFavoriteUseCase.delete(itemDto) }
    }

}