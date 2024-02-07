package ge.semenchuk.store.app.stroreapp.domain.usecase

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.repositories.FavoriteRepository
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.SaveFavoriteUseCase

class SaveFavoriteUseCaseImpl(
    private val favoriteRepository: FavoriteRepository,
) : SaveFavoriteUseCase {
    override suspend fun add(itemDto: ItemDto): Long {
        return favoriteRepository.add(itemDto)
    }
}