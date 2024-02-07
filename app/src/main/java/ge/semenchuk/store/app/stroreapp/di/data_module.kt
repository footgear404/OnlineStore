package ge.semenchuk.store.app.stroreapp.di

import androidx.room.Room
import ge.semenchuk.store.app.stroreapp.BuildConfig.BASE_URL
import ge.semenchuk.store.app.stroreapp.data.api.OnlineStoreApi
import ge.semenchuk.store.app.stroreapp.data.repositories.FavoriteRepositoryImpl
import ge.semenchuk.store.app.stroreapp.data.repositories.OnlineStoreRepositoryImpl
import ge.semenchuk.store.app.stroreapp.data.repositories.UserRepositoryImpl
import ge.semenchuk.store.app.stroreapp.data.storage.db.AppDatabase
import ge.semenchuk.store.app.stroreapp.data.storage.db.FavoriteDao
import ge.semenchuk.store.app.stroreapp.data.storage.db.UserDao
import ge.semenchuk.store.app.stroreapp.domain.repositories.FavoriteRepository
import ge.semenchuk.store.app.stroreapp.domain.repositories.OnlineStoreRepository
import ge.semenchuk.store.app.stroreapp.domain.repositories.UserRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val data = module {

    single<AppDatabase> {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "online-store-db"
        ).build()
    }
    single<UserDao> {
        get<AppDatabase>().userDao()
    }
    single<FavoriteDao> {
        get<AppDatabase>().favoriteDao()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single<OnlineStoreApi> {
        get<Retrofit>().create(OnlineStoreApi::class.java)
    }

    single<UserRepository> {
        UserRepositoryImpl(userDao = get<UserDao>())
    }

    single<FavoriteRepository> {
        FavoriteRepositoryImpl(favoriteDao = get<FavoriteDao>())
    }

    single<OnlineStoreRepository> {
        OnlineStoreRepositoryImpl(onlineStoreApi = get<OnlineStoreApi>())
    }
}