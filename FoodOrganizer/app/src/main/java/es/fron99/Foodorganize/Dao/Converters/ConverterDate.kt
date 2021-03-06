package es.fron99.Foodorganize.Dao.Converters

import androidx.room.TypeConverter
import java.util.*

class ConverterDate {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

}
