package com.example.zakiapps2.body

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.zakiapps2.model.Makanan
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zakiapps2.R
import com.example.zakiapps2.Routes

@Composable
fun DetailMakananBody(navController: NavController, makanan: Makanan) {

    val customFontFamily = FontFamily(
        Font(R.font.medium, FontWeight.Medium),
        Font(R.font.bold, FontWeight.Bold)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = makanan.gambar),
            contentDescription = makanan.nama,
            modifier = Modifier
                .width(300.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = makanan.nama,
            fontSize = 24.sp,
            fontFamily = customFontFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = makanan.deskripsi,
            fontSize = 16.sp,
            fontFamily = customFontFamily,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )

        Button(
            onClick = {
                navController.navigate(Routes.KeranjangActivity)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFe02d39))
        ) {
            Text(
                text = "Pesan",
                color = Color.White,
                fontFamily = customFontFamily,
                modifier = Modifier
                    .padding(5.dp)

            )
        }

    }
}


