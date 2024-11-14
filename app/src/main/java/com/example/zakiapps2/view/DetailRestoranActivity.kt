package com.example.zakiapps2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.zakiapps2.body.DetailMakananBody
import com.example.zakiapps2.body.DetailRestoranBody
import com.example.zakiapps2.component.HeaderDetailMakanan
import com.example.zakiapps2.component.HeaderDetailRestoran
import com.example.zakiapps2.component.NavbarBotom
import com.example.zakiapps2.data.daftarMakanan
import com.example.zakiapps2.data.daftarRestoran
import com.example.zakiapps2.model.Makanan
import com.example.zakiapps2.model.Restoran

@Composable
fun DetailRestoranActivity(navController: NavController, restoranId: Int) {
    val daftarRestoran = daftarRestoran
    val restoran = daftarRestoran.find { it.id == restoranId }

    if (restoran != null) {
        DetailRestoranScreen(navController, restoran)
    } else {
        Text("Makanan tidak ditemukan")
    }
}

@Composable
fun DetailRestoranScreen(navController: NavController, restoran: Restoran) {
    Scaffold(
        bottomBar = {
            NavbarBotom(navController)
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFf5f5f5))
        ) {
            HeaderDetailRestoran(navController)
            DetailRestoranBody(restoran = restoran)
        }
    }
}