package ge.semenchuk.store.app.stroreapp.domain.usecase.interfaces

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto

interface SaveFavoriteUseCase {

    suspend fun add(itemDto: ItemDto): Long

}