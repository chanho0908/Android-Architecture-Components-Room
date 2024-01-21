package kr.co.lion.automigration.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.*
import java.io.ByteArrayOutputStream
import java.util.Date

@Entity(tableName = "text_table")
data class TextEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "text")
    val text : String,
    @ColumnInfo(name = "currentDate")
    val currentDate : Date,
    @ColumnInfo(name = "photo")
    val myPhoto : Bitmap
)

class MyConverters {

    @TypeConverter
    fun fromTimestampToDate(value : Long) : Date {
        return Date(value)
    }

    @TypeConverter
    fun fromDateToTimestamp(date : Date) : Long {
        return date.time
    }

    @TypeConverter
    fun fromBitmapToByteArray(bitmap: Bitmap) : ByteArray {

        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()

    }

    @TypeConverter
    fun fromByteArrayToBitmap(byteArray: ByteArray) : Bitmap {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    }

    @TypeConverter
    fun listToJson(list: MutableList<TextEntity>): String{
        return Gson.toJson(list)
    }

    @TypeConverter
    fun jsonToList(value: String): MutableList<TextEntity>{
        return Gson.fromJson(value, Array<TextEntity>::class.java).toMutableLust()
    }
}