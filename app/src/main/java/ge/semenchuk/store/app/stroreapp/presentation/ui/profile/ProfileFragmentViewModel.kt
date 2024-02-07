package ge.semenchuk.store.app.stroreapp.presentation.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.dto.UserDto
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.GetFavoritesUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserProfileUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileFragmentViewModel(
    getFavoritesUseCase: GetFavoritesUseCase,
    private val userProfileUseCase: UserProfileUseCase,
) : ViewModel() {

    private var _user = MutableStateFlow<UserDto?>(null)
    val user = _user.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _user.value = userProfileUseCase.getUserProfile()
        }
    }

    val favorite: Flow<List<ItemDto>> = getFavoritesUseCase.execute()

    fun logout() {
        viewModelScope.launch(Dispatchers.IO) {
            user.value?.let { userProfileUseCase.logoutUser(it) }
        }
    }
}