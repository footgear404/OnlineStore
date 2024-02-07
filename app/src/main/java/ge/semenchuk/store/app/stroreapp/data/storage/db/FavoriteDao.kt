package ge.semenchuk.store.app.stroreapp.data.storage.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ge.semenchuk.store.app.stroreapp.data.storage.models.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(favoriteEntity: FavoriteEntity): Long

    @Query("SELECT * FROM FavoriteEntity")
    fun getAll(): Flow<List<FavoriteEntity>>

    @Delete
    fun delete(favoriteEntity: FavoriteEntity)
}