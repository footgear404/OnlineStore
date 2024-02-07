package ge.semenchuk.store.app.stroreapp.domain.dto


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ge.semenchuk.store.app.stroreapp.domain.entity.Item
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ItemDto(
    @Json(name = "available")
    override val available: Int,
    @Json(name = "description")
    override val description: String?,
    @Json(name = "feedback")
    override val feedbackDto: FeedbackDto?,
    @Json(name = "id")
    override val id: String,
    @Json(name = "info")
    override val infoDto: List<InfoDto?>,
    @Json(name = "ingredients")
    override val ingredients: String?,
    @Json(name = "price")
    override val priceDto: PriceDto?,
    @Json(name = "subtitle")
    override val subtitle: String?,
    @Json(name = "tags")
    override val tags: List<String?>,
    @Json(name = "title")
    override val title: String?,
    override var isFavorite: Boolean = false,
) : Item, Parcelable