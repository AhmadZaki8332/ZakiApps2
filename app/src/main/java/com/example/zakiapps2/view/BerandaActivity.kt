package com.example.zakiapps2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.zakiapps2.body.BerandaBody
import com.example.zakiapps2.component.HeaderBeranda
import com.example.zakiapps2.component.NavbarBotom
import com.example.zakiapps2.data.daftarMakanan
import com.example.zakiapps2.data.daftarRestoran

@Composable
fun BerandaActivity(navController: NavController) {
    HomeScreen(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
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
            HeaderBeranda(navController)
            BerandaBody(navController = navController, daftarMakanan = daftarMakanan, daftarRestoran = daftarRestoran)
        }
    }
}


