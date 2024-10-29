package rh.mobile.listtugas.ui.theme

import android.app.Application
import androidx.room.Room
import rh.mobile.listtugas.database.TugasDatabase

class MainApplication : Application() {

    companion object {
        lateinit var tugasDatabase : TugasDatabase
    }

    override fun onCreate() {
        super.onCreate()
        tugasDatabase = Room.databaseBuilder(
            applicationContext,
            TugasDatabase::class.java,
            TugasDatabase.NAME
        ).build()
    }
}