package ge.semenchuk.store.app.stroreapp.domain.utils.support

sealed class State {
    data object Loading : State()
    data object Success : State()
    data object Await : State()
    data class Error(val message: String) : State()
}