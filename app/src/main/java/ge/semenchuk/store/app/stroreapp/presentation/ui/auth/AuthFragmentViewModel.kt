package ge.semenchuk.store.app.stroreapp.presentation.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserAuthorizationUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserRegistrationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AuthFragmentViewModel(
    private val userAuthorizationUseCase: UserAuthorizationUseCase,
    private val userRegistrationUseCase: UserRegistrationUseCase,
) : ViewModel() {
    private var _isAuthorized = Channel<Boolean>()
    val isAuthorized = _isAuthorized.receiveAsFlow()

    init {
        checkAuthorization()
    }

    private fun checkAuthorization() {
        viewModelScope.launch(Dispatchers.IO) {
            _isAuthorized.send(userAuthorizationUseCase.checkUserAuthorization())
        }
    }

    fun registerUser(name: String, sName: String, phone: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val userRegistrationResult = userRegistrationUseCase.registration(name, sName, phone)
            _isAuthorized.send(userRegistrationResult)
        }
    }
}