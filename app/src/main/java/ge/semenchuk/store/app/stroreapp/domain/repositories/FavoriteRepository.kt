package ge.semenchuk.store.app.stroreapp.domain.repositories

import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun execute(): Flow<List<ItemDto>>

    suspend fun add(itemDto: ItemDto): Long

    suspend fun delete(itemDto: ItemDto)
}