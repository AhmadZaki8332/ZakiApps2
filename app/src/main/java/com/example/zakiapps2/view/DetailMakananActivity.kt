package com.example.zakiapps2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.zakiapps2.body.DetailMakananBody
import com.example.zakiapps2.component.HeaderBeranda
import com.example.zakiapps2.component.HeaderDetailMakanan
import com.example.zakiapps2.component.NavbarBotom
import com.example.zakiapps2.data.daftarMakanan
import com.example.zakiapps2.model.Makanan

@Composable
fun DetailMakananActivity(navController: NavController, makananId: Int) {
    val daftarMakanan = daftarMakanan
    val makanan = daftarMakanan.find { it.id == makananId }

    if (makanan != null) {
        DetailMakananScreen(navController, makanan)
    }
}

@Composable
fun DetailMakananScreen(navController: NavController, makanan: Makanan) {
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
            HeaderDetailMakanan(navController)
            DetailMakananBody(navController, makanan = makanan)
        }
    }
}


