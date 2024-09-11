package com.example.pertemuan2_splash

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pertemuan2_splash.ui.theme.Orange
import com.example.pertemuan2_splash.ui.theme.Pertemuan2_splashTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pertemuan2_splashTheme {
                SplashPreview()
            }
        }
    }
}

@Composable
fun Splash() {
    Column (
        modifier = Modifier.background(color = Orange),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
            Image(
                modifier = Modifier
                    .padding(top = 181.dp)
                    .size(200.dp),
                painter = painterResource(id = R.drawable.splashvolty),
                contentDescription = "picture"
            )


        Surface (
            modifier = Modifier
                .fillMaxSize(),
            color = Color(0xFFFF9630)

        ){
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    modifier = Modifier
                        .padding(top = 50.dp),
                    text = "Lebih hemat bersama Volty!",
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    modifier = Modifier
                        .padding(end = 50.dp, start = 50.dp),
                    text = "Dengan Volty, kamu dapat menghemat biaya pengeluaran listrik rumah!",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    modifier = Modifier
                        .size(43.dp),
                    painter = painterResource(id = R.drawable.grupsplash),
                    contentDescription = "dekor"
                )

                Spacer(modifier = Modifier.height(80.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(White)
                ) {
                    Text(
                        text = "Daftar Sekarang",
                        fontSize = 18.sp,
                        color = Color(0xFFFF9630)
                    )
                }



                TextButton(
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = "Sudah Memiliki Akun?",
                        fontSize = 18.sp,
                        color = White,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    Pertemuan2_splashTheme {
        Splash()
    }
}