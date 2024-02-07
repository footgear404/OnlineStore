package ge.semenchuk.store.app.stroreapp.domain.usecase

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.repositories.OnlineStoreRepository
import ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces.GetItemsFromApiUseCase

class GetItemsFromApiUseCaseImpl(
    private val onlineStoreRepository: OnlineStoreRepository,
) : GetItemsFromApiUseCase {
    override suspend fun execute(): List<ItemDto> {
        return onlineStoreRepository.getItems()
    }
}