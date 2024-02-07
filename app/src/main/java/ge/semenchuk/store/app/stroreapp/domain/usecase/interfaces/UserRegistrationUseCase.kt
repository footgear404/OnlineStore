package ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces

interface UserRegistrationUseCase {
    suspend fun registration(name: String, sName: String, phone: String) : Boolean

}