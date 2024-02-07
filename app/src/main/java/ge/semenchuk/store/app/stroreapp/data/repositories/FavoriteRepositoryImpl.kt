package ge.semenchuk.store.app.stroreapp.data.repositories

import ge.semenchuk.store.app.stroreapp.data.storage.db.FavoriteDao
import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.repositories.FavoriteRepository
import ge.semenchuk.store.app.stroreapp.domain.utils.mappers.StoreItemMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteRepositoryImpl(
    private val favoriteDao: FavoriteDao,
) : FavoriteRepository {
    override fun execute(): Flow<List<ItemDto>> {
        return favoriteDao.getAll().map { list ->
            list.map {
                StoreItemMapper.fromFavoriteEntity(it) as ItemDto
            }
        }
    }

    override suspend fun add(itemDto: ItemDto): Long {
        return favoriteDao.insert(StoreItemMapper.toFavoriteEntity(itemDto))
    }

    override suspend fun delete(itemDto: ItemDto) {
        favoriteDao.delete(StoreItemMapper.toFavoriteEntity(itemDto))
    }

}