package ge.semenchuk.store.app.stroreapp.data.storage.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ge.semenchuk.store.app.stroreapp.data.storage.models.FavoriteEntity
import ge.semenchuk.store.app.stroreapp.data.storage.models.UserEntity
import ge.semenchuk.store.app.stroreapp.domain.convertors.InfoDtoListConverter
import ge.semenchuk.store.app.stroreapp.domain.convertors.StringListConverter

@TypeConverters(InfoDtoListConverter::class, StringListConverter::class)
@Database(entities = [UserEntity::class, FavoriteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun favoriteDao(): FavoriteDao

}