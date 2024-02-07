package ge.semenchuk.store.app.stroreapp.domain.usecase

import ge.semenchuk.store.app.stroreapp.domain.repositories.UserRepository
import ge.semenchuk.store.app.stroreapp.domain.dto.UserDto
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserRegistrationUseCase
import ge.semenchuk.store.app.stroreapp.domain.utils.unmaskedPhoneNumber

class UserRegistrationUseCaseImpl(
    private val userRepository: UserRepository,
) : UserRegistrationUseCase {
    override suspend fun registration(name: String, sName: String, phone: String): Boolean {
        val result = userRepository.saveUser(
            UserDto(
                uName = name,
                uSecondName = sName,
                uPhoneNumber = phone.unmaskedPhoneNumber()
            )
        )
        return result != 0L
    }
}