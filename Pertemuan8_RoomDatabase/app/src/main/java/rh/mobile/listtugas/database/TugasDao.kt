package rh.mobile.listtugas.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import rh.mobile.listtugas.ui.theme.Tugas

@Dao
interface TugasDao {

    @Query("SELECT * FROM TUGAS")
    fun getAllTugas(): LiveData<List<Tugas>>

    @Query("SELECT * FROM TUGAS WHERE id = :id LIMIT 1")
    fun getTugasById(id: Int): Tugas?

    @Insert
    fun addTugas(tugas: Tugas)
}
