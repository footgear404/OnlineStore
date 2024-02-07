package ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces

import ge.semenchuk.store.app.stroreapp.domain.dto.UserDto

interface UserProfileUseCase {
    suspend fun getUserProfile(): UserDto

    suspend fun logoutUser(userDto: UserDto)
}