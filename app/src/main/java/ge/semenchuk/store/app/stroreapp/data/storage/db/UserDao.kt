package ge.semenchuk.store.app.stroreapp.data.storage.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ge.semenchuk.store.app.stroreapp.data.storage.models.UserEntity

@Dao
interface UserDao {
    @Insert
    fun insert(user: UserEntity): Long

    @Delete
    fun delete(user: UserEntity)

    @Query("SELECT * FROM UserEntity")
    fun getAll(): List<UserEntity>
}