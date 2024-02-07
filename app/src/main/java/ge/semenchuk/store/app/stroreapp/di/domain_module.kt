package ge.semenchuk.store.app.stroreapp.di

import ge.semenchuk.store.app.stroreapp.domain.repositories.FavoriteRepository
import ge.semenchuk.store.app.stroreapp.domain.repositories.OnlineStoreRepository
import ge.semenchuk.store.app.stroreapp.domain.repositories.UserRepository
import ge.semenchuk.store.app.stroreapp.domain.usecase.GetFavoritesUseCaseImpl
import ge.semenchuk.store.app.stroreapp.domain.usecase.GetItemsFromApiUseCaseImpl
import ge.semenchuk.store.app.stroreapp.domain.usecase.RemoveFromFavoriteUseCaseImpl
import ge.semenchuk.store.app.stroreapp.domain.usecase.SaveFavoriteUseCaseImpl
import ge.semenchuk.store.app.stroreapp.domain.usecase.UserAuthorizationUseCaseImpl
import ge.semenchuk.store.app.stroreapp.domain.usecase.UserProfileUseCaseImpl
import ge.semenchuk.store.app.stroreapp.domain.usecase.UserRegistrationUseCaseImpl
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.GetFavoritesUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.GetItemsFromApiUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.RemoveFromFavoriteUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.SaveFavoriteUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserAuthorizationUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserProfileUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserRegistrationUseCase
import org.koin.dsl.module

val domain = module {

    single<UserAuthorizationUseCase> {
        UserAuthorizationUseCaseImpl(
            userRepository = get<UserRepository>()
        )
    }

    single<UserRegistrationUseCase> {
        UserRegistrationUseCaseImpl(
            userRepository = get<UserRepository>()
        )
    }

    single<UserProfileUseCase> {
        UserProfileUseCaseImpl(userRepository = get<UserRepository>())
    }

    single<GetItemsFromApiUseCase> {
        GetItemsFromApiUseCaseImpl(
            get<OnlineStoreRepository>()
        )
    }

    single<GetFavoritesUseCase> {
        GetFavoritesUseCaseImpl(favoriteRepository = get<FavoriteRepository>())
    }

    single<SaveFavoriteUseCase> {
        SaveFavoriteUseCaseImpl(favoriteRepository = get<FavoriteRepository>())
    }

    single<RemoveFromFavoriteUseCase> {
        RemoveFromFavoriteUseCaseImpl(favoriteRepository = get<FavoriteRepository>())
    }

}