package ge.semenchuk.store.app.stroreapp.domain.convertors

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ge.semenchuk.store.app.stroreapp.domain.dto.InfoDto

class InfoDtoListConverter {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val listType = Types.newParameterizedType(List::class.java, InfoDto::class.java)
    private val jsonAdapter = moshi.adapter<List<InfoDto?>>(listType)

    @TypeConverter
    fun fromInfoDtoList(infoDtoList: List<InfoDto?>): String {
        return jsonAdapter.toJson(infoDtoList)
    }

    @TypeConverter
    fun toInfoDtoList(infoDtoListString: String): List<InfoDto?>? {
        return jsonAdapter.fromJson(infoDtoListString)
    }
}