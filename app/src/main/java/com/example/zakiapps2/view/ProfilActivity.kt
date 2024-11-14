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
import com.example.zakiapps2.body.MenuBody
import com.example.zakiapps2.body.ProfiBody
import com.example.zakiapps2.component.HeaderMenu
import com.example.zakiapps2.component.NavbarBotom
import com.example.zakiapps2.data.daftarMakananGrid

@Composable
fun ProfilActivity(navController: NavController) {
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
            ProfiBody(navController)
        }
    }


}