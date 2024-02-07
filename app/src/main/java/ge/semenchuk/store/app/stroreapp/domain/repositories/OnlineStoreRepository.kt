package ge.semenchuk.store.app.stroreapp.domain.repositories

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto

interface OnlineStoreRepository {
    suspend fun getItems(): List<ItemDto>

}