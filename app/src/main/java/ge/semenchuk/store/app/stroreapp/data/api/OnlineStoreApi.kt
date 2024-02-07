package ge.semenchuk.store.app.stroreapp.data.api

import ge.semenchuk.store.app.stroreapp.domain.dto.StoreResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface OnlineStoreApi {
    @GET("v3/97e721a7-0a66-4cae-b445-83cc0bcf9010")
    suspend fun getAll(): Response<StoreResponseDto>

}