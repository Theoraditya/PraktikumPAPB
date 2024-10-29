package com.example.pertemuan8_roomdatabase


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan8_roomdatabase.R.drawable.one_note
import com.example.pertemuan8_roomdatabase.ui.theme.PurpleOneNote

@Composable
fun LoginUi(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf("") }
    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current // Mendapatkan context
    val coroutineScope = rememberCoroutineScope() // Mendapatkan CoroutineScope


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleOneNote) // Latar belakang ungu
    ) {
        Column {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                color = Color.White,
                shape = RoundedCornerShape(bottomStart = 80.dp, bottomEnd = 80.dp) // Menetapkan bentuk sudut
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = one_note), // Pastikan file ini ada
                        contentDescription = "One Note Logo",
                        modifier = Modifier.size(90.dp)
                    )
                    Text(
                        text = "Microsoft One Note",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = PurpleOneNote,
                        modifier = Modifier.padding(top = 15.dp)
                    )
                    Text(
                        text = "Log in to your account to access the app",
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .padding(top = 49.dp, start = 30.dp, end = 30.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Log In",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = "Email Address", color = Color.White) },
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.LightGray,
                            focusedBorderColor = Color.LightGray,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        )
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = "Password", color = Color.White) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.LightGray,
                            focusedBorderColor = Color.LightGray,
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White
                        ),
                        visualTransformation = PasswordVisualTransformation() // Menyembunyikan input password
                    )
                    Button(
                        onClick = {
                            auth.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        Toast.makeText(context, "Sign Up Berhasil", Toast.LENGTH_SHORT).show()
                                        navController.navigate("home/$email")
                                    } else {
                                        val errorMessage = task.exception?.message ?: "Sign Up gagal"
                                        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                                    }
                                }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = PurpleOneNote
                        )
                    ) {
                        Text(text = "Log in")
                    }
                    if (loginError.isNotEmpty()) {
                        Text(
                            text = loginError,
                            color = Color.Red,
                            modifier = Modifier.padding(top = 16.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                    Text(
                        text = "Forgot password?",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    val navController = rememberNavController() // Dummy navController for preview
    LoginUi(navController)}
