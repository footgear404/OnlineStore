package ge.semenchuk.store.app.stroreapp.domain.dto


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ge.semenchuk.store.app.stroreapp.domain.entity.Info
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class InfoDto(
    @Json(name = "title")
    override val title: String?,
    @Json(name = "value")
    override val value: String?,
) : Info, Parcelable