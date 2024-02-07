package ge.semenchuk.store.app.stroreapp.domain.convertors

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class StringListConverter {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val listType = Types.newParameterizedType(List::class.java, String::class.java)
    private val jsonAdapter = moshi.adapter<List<String?>>(listType)

    @TypeConverter
    fun fromStringList(stringList: List<String?>): String {
        return jsonAdapter.toJson(stringList)
    }

    @TypeConverter
    fun toStringList(stringListString: String): List<String?>? {
        return jsonAdapter.fromJson(stringListString)
    }
}