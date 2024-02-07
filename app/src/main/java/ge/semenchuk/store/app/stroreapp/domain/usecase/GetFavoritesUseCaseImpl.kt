package ge.semenchuk.store.app.stroreapp.domain.usecase

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.repositories.FavoriteRepository
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.GetFavoritesUseCase
import kotlinx.coroutines.flow.Flow

class GetFavoritesUseCaseImpl(
    private val favoriteRepository: FavoriteRepository,
) : GetFavoritesUseCase {
    override fun execute(): Flow<List<ItemDto>> {
        return favoriteRepository.execute()
    }
}