package ge.semenchuk.store.app.stroreapp.domain.usecase

import ge.semenchuk.store.app.stroreapp.domain.repositories.UserRepository
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserAuthorizationUseCase

class UserAuthorizationUseCaseImpl(
    private val userRepository: UserRepository,
) : UserAuthorizationUseCase {
    override suspend fun checkUserAuthorization(): Boolean {
        val user = userRepository.load()
        return user != null
    }
}