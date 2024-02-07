package ge.semenchuk.store.app.stroreapp.data.repositories

import ge.semenchuk.store.app.stroreapp.data.storage.db.UserDao
import ge.semenchuk.store.app.stroreapp.data.storage.models.UserEntity
import ge.semenchuk.store.app.stroreapp.domain.entity.User
import ge.semenchuk.store.app.stroreapp.domain.repositories.UserRepository
import ge.semenchuk.store.app.stroreapp.domain.utils.mappers.UserMapper

class UserRepositoryImpl(
    private val userDao: UserDao,
) : UserRepository {
    override suspend fun saveUser(user: User): Long {
        return userDao.insert(UserMapper.toUserEntity(user))
    }

    override suspend fun load(): User? {
        val userList = userDao.getAll()
        return if (userList.isNotEmpty())
            userList[0]
        else
            null
    }

    override suspend fun removeUser(user: UserEntity) {
        userDao.delete(user = user)
    }
}