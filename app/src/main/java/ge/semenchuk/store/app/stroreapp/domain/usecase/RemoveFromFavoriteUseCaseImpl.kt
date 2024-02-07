package ge.semenchuk.store.app.stroreapp.domain.usecase

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.repositories.FavoriteRepository
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.RemoveFromFavoriteUseCase

class RemoveFromFavoriteUseCaseImpl(
    private val favoriteRepository: FavoriteRepository,
) : RemoveFromFavoriteUseCase {
    override suspend fun delete(itemDto: ItemDto) {
        favoriteRepository.delete(itemDto)
    }
}