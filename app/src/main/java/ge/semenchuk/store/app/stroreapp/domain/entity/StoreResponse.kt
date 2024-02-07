package ge.semenchuk.store.app.stroreapp.domain.entity

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto

interface StoreResponse {
    val items: List<ItemDto>
}