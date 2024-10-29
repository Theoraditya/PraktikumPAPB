package rh.mobile.listtugas.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import rh.mobile.listtugas.ui.theme.Tugas

@Database(entities = [Tugas::class], version = 1)
@TypeConverters(Converter::class)
abstract class TugasDatabase : RoomDatabase() {

    companion object {
        const val NAME = "Tugas_DB"
    }

    abstract  fun getTugasDao() : TugasDao
}