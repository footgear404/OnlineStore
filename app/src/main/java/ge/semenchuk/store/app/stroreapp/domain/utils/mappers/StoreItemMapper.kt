package ge.semenchuk.store.app.stroreapp.domain.utils.mappers

import ge.semenchuk.store.app.stroreapp.data.storage.models.FavoriteEntity
import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.entity.Item


object StoreItemMapper {

    fun fromFavoriteEntity(favoriteEntity: FavoriteEntity): Item {
        return ItemDto(
            available = favoriteEntity.available,
            description = favoriteEntity.description,
            feedbackDto = favoriteEntity.feedbackDto,
            id = favoriteEntity.id,
            infoDto = favoriteEntity.infoDto,
            ingredients = favoriteEntity.ingredients,
            priceDto = favoriteEntity.priceDto,
            subtitle = favoriteEntity.subtitle,
            tags = favoriteEntity.tags,
            title = favoriteEntity.title,
            isFavorite = favoriteEntity.isFavorite
        )
    }

    fun toFavoriteEntity(item: Item): FavoriteEntity {
        return FavoriteEntity(
            available = item.available,
            description = item.description,
            feedbackDto = item.feedbackDto,
            id = item.id,
            infoDto = item.infoDto,
            ingredients = item.ingredients,
            priceDto = item.priceDto,
            subtitle = item.subtitle,
            tags = item.tags,
            title = item.title,
            isFavorite = item.isFavorite
        )
    }

}