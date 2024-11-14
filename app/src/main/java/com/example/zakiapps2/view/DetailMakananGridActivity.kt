package com.example.zakiapps2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.zakiapps2.body.DetailMakananBody
import com.example.zakiapps2.body.DetailMenuBody
import com.example.zakiapps2.component.HeaderDetailMakanan
import com.example.zakiapps2.component.NavbarBotom
import com.example.zakiapps2.data.daftarMakananGrid
import com.example.zakiapps2.model.MakananGrid

@Composable
fun DetailMakananGridActivity(navController: NavController, makanangridId: Int) {
    val daftarMakananGrid = daftarMakananGrid
    val makanangrid = daftarMakananGrid.find { it.id == makanangridId }

    if (makanangrid != null) {
        DetailMakananGridScreen(navController, makanangrid)
    }
}

@Composable
fun DetailMakananGridScreen(navController: NavController, makanangrid: MakananGrid) {
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
            DetailMenuBody(navController,makanangrid = makanangrid)
        }
    }
}
