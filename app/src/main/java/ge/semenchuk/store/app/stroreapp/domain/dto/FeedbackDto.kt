package ge.semenchuk.store.app.stroreapp.domain.dto


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ge.semenchuk.store.app.stroreapp.domain.entity.Feedback
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class FeedbackDto(
    @Json(name = "count")
    override val count: Int?,
    @Json(name = "rating")
    override val rating: Double?,
) : Feedback, Parcelable