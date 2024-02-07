package ge.semenchuk.store.app.stroreapp.data.storage.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ge.semenchuk.store.app.stroreapp.domain.convertors.InfoDtoListConverter
import ge.semenchuk.store.app.stroreapp.domain.convertors.StringListConverter
import ge.semenchuk.store.app.stroreapp.domain.dto.FeedbackDto
import ge.semenchuk.store.app.stroreapp.domain.dto.InfoDto
import ge.semenchuk.store.app.stroreapp.domain.dto.PriceDto
import ge.semenchuk.store.app.stroreapp.domain.entity.Item

@Entity
class FavoriteEntity(
    @PrimaryKey
    override val id: String,
    override val available: Int,
    override val description: String?,
    @Embedded(prefix = "feedback_")
    override val feedbackDto: FeedbackDto?,
    @TypeConverters(InfoDtoListConverter::class)
    override val infoDto: List<InfoDto?>,
    override val ingredients: String?,
    @Embedded(prefix = "price_")
    override val priceDto: PriceDto?,
    override val subtitle: String?,
    @TypeConverters(StringListConverter::class)
    override val tags: List<String?>,
    override val title: String?,
    override var isFavorite: Boolean,
) : Item