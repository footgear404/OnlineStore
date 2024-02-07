package ge.semenchuk.store.app.stroreapp.domain.repositories

import ge.semenchuk.store.app.stroreapp.data.storage.models.UserEntity
import ge.semenchuk.store.app.stroreapp.domain.entity.User

interface UserRepository {

    suspend fun saveUser(user: User) : Long

    suspend fun load(): User?

    suspend fun removeUser(user: UserEntity)

}