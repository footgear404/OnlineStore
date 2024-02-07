package ge.semenchuk.store.app.stroreapp.domain.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ge.semenchuk.store.app.stroreapp.domain.entity.StoreResponse

@JsonClass(generateAdapter = true)
data class StoreResponseDto(
    @Json(name = "items")
    override val items: List<ItemDto>,
) : StoreResponse
