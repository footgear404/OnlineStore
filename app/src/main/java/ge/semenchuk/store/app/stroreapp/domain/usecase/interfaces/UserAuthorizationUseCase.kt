package ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces

interface UserAuthorizationUseCase {
    suspend fun checkUserAuthorization() : Boolean

}