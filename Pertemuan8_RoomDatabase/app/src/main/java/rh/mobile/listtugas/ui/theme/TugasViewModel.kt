package rh.mobile.listtugas.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class TugasViewModel : ViewModel() {
    private val tugasDao = MainApplication.tugasDatabase.getTugasDao()

    val tugasList: LiveData<List<Tugas>> = tugasDao.getAllTugas()

    fun addTugas(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (title.isNotEmpty()) {
                tugasDao.addTugas(Tugas(title = title, createdAt = Date.from(Instant.now())))
            }
        }
    }
}
