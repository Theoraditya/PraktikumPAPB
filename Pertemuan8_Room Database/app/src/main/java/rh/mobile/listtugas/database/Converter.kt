package rh.mobile.listtugas.database

import androidx.room.TypeConverter
import java.util.Date

class Converter {

    @TypeConverter
    fun fromDate(date : Date) : Long{
        return date.time
    }

    @TypeConverter
    fun toDate(time : Long) : Date{
        return Date(time)
    }
}