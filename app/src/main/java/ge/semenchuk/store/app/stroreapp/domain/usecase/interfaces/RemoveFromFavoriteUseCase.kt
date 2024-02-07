package ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto

interface RemoveFromFavoriteUseCase {

    suspend fun delete(itemDto: ItemDto)

}