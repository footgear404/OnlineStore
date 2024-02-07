package ge.semenchuk.store.app.stroreapp.domain.utils.mappers

import ge.semenchuk.store.app.stroreapp.data.storage.models.UserEntity
import ge.semenchuk.store.app.stroreapp.domain.dto.UserDto
import ge.semenchuk.store.app.stroreapp.domain.entity.User

object UserMapper {
    fun fromUserEntity(userEntity: UserEntity): UserDto {
        return UserDto(
            uName = userEntity.uName,
            uSecondName = userEntity.uSecondName,
            uPhoneNumber = userEntity.uPhoneNumber
        )
    }

    fun toUserEntity(user: User): UserEntity {
        return UserEntity(
            uName = user.uName,
            uSecondName = user.uSecondName,
            uPhoneNumber = user.uPhoneNumber
        )
    }
}