package ge.semenchuk.store.app.stroreapp.domain.dto

import ge.semenchuk.store.app.stroreapp.domain.entity.User

class UserDto(
    override val uName: String,
    override val uSecondName: String,
    override val uPhoneNumber: String,
) : User