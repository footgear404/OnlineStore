package ge.semenchuk.store.app.stroreapp.domain.usecase

import ge.semenchuk.store.app.stroreapp.data.storage.models.UserEntity
import ge.semenchuk.store.app.stroreapp.domain.dto.UserDto
import ge.semenchuk.store.app.stroreapp.domain.repositories.UserRepository
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserProfileUseCase
import ge.semenchuk.store.app.stroreapp.domain.utils.mappers.UserMapper

class UserProfileUseCaseImpl(
    private val userRepository: UserRepository,
) : UserProfileUseCase {
    override suspend fun getUserProfile(): UserDto {
        val user = userRepository.load()
        return UserMapper.fromUserEntity(user as UserEntity)
    }

    override suspend fun logoutUser(userDto: UserDto) {
        userRepository.removeUser(UserMapper.toUserEntity(userDto))
    }
}