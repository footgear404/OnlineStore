package ge.semenchuk.store.app.stroreapp.di

import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.GetFavoritesUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.GetItemsFromApiUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.SaveFavoriteUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserAuthorizationUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserProfileUseCase
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.UserRegistrationUseCase
import ge.semenchuk.store.app.stroreapp.presentation.ui.auth.AuthFragmentViewModel
import ge.semenchuk.store.app.stroreapp.presentation.ui.catalog.CatalogFragmentViewModel
import ge.semenchuk.store.app.stroreapp.presentation.ui.profile.ProfileFragmentViewModel
import ge.semenchuk.store.app.stroreapp.presentation.ui.profile.favorite.FavoriteFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation = module {
    viewModel<AuthFragmentViewModel> {
        AuthFragmentViewModel(
            userAuthorizationUseCase = get<UserAuthorizationUseCase>(),
            userRegistrationUseCase = get<UserRegistrationUseCase>()
        )
    }

    viewModel<CatalogFragmentViewModel> {
        CatalogFragmentViewModel(
            getItemsFromApiUseCase = get<GetItemsFromApiUseCase>(),
            saveFavoriteUseCase = get<SaveFavoriteUseCase>(),
            getFavoritesUseCase = get(),
            removeFromFavoriteUseCase = get()
        )
    }

    viewModel<ProfileFragmentViewModel> {
        ProfileFragmentViewModel(
            getFavoritesUseCase = get<GetFavoritesUseCase>(),
            userProfileUseCase = get<UserProfileUseCase>()
        )
    }

    viewModel<FavoriteFragmentViewModel> {
        FavoriteFragmentViewModel(
            saveFavoriteUseCase = get<SaveFavoriteUseCase>(),
            getFavoritesUseCase = get(),
            removeFromFavoriteUseCase = get()
        )
    }
}