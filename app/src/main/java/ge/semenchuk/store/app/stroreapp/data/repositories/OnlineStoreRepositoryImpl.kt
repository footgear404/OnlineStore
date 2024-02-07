package ge.semenchuk.store.app.stroreapp.data.repositories

import android.util.Log
import ge.semenchuk.store.app.stroreapp.data.api.OnlineStoreApi
import ge.semenchuk.store.app.stroreapp.domain.dto.ItemDto
import ge.semenchuk.store.app.stroreapp.domain.dto.StoreResponseDto
import ge.semenchuk.store.app.stroreapp.domain.repositories.OnlineStoreRepository
import ge.semenchuk.store.app.stroreapp.domain.utils.Constants
import retrofit2.Response

class OnlineStoreRepositoryImpl(
    private val onlineStoreApi: OnlineStoreApi,
) : OnlineStoreRepository {
    private var response: Response<StoreResponseDto>? = null
    override suspend fun getItems(): List<ItemDto> {
        try {
            response = onlineStoreApi.getAll()
            response?.let { response ->
                if (response.isSuccessful) {
                    response.body()?.let {
                        return it.items
                    }
                }
            }
        } catch (e: Exception) {
            Log.d(Constants.Log.API, "error: $e")
        }
        Log.d(Constants.Log.API, "response: ${response?.code()} ${response?.message()}")
        return emptyList()
    }
}