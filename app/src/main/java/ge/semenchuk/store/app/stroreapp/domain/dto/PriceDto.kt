package ge.semenchuk.store.app.stroreapp.domain.dto


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ge.semenchuk.store.app.stroreapp.domain.entity.Price
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PriceDto(
    @Json(name = "discount")
    override val discount: Int?,
    @Json(name = "price")
    override val price: String?,
    @Json(name = "priceWithDiscount")
    override val priceWithDiscount: String?,
    @Json(name = "unit")
    override val unit: String?,
) : Price, Parcelable