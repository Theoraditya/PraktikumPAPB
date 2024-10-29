package rh.mobile.listtugas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import kotlinx.coroutines.launch
import rh.mobile.listtugas.ui.theme.ListTugasTheme
import rh.mobile.listtugas.ui.theme.Tugas
import rh.mobile.listtugas.ui.theme.TugasViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListTugasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TugasScreen()
                }
            }
        }
    }
}

@Composable
fun TugasScreen(viewModel: TugasViewModel = viewModel()) {
    val tugasList by viewModel.tugasList.observeAsState(emptyList())
    val coroutineScope = rememberCoroutineScope()

    var newTugasTitle by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = newTugasTitle,
            onValueChange = { newTugasTitle = it },
            label = { Text("Masukkan Tugas Baru") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                coroutineScope.launch {
                    viewModel.addTugas(newTugasTitle)
                    newTugasTitle = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Tambah Tugas")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Menampilkan daftar tugas
        Text("Daftar Tugas", style = MaterialTheme.typography.titleMedium)

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tugasList) { tugas ->
                TugasCard(tugas = tugas)
            }
        }
    }
}

@Composable
fun TugasCard(tugas: Tugas) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = tugas.title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            val dateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
            val formattedDate = dateFormat.format(tugas.createdAt)

            Text(
                text = "Dibuat pada: $formattedDate",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TugasScreenPreview() {
    ListTugasTheme {
        TugasScreen()
    }
}
