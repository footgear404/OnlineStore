package ge.semenchuk.store.app.stroreapp.data.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import ge.semenchuk.store.app.stroreapp.domain.entity.User

@Entity
data class UserEntity(
    override val uName: String,
    override val uSecondName: String,
    @PrimaryKey
    override val uPhoneNumber: String,
) : User