package ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto

interface GetItemsFromApiUseCase {
    suspend fun execute(): List<ItemDto>

}