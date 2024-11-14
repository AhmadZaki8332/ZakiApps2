package com.example.zakiapps2.navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.zakiapps2.body.BerandaBody
import com.example.zakiapps2.body.DataMakanan
import com.example.zakiapps2.body.DetailMakananBody
import com.example.zakiapps2.data.daftarMakanan

/*
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            BerandaBody(navController = navController, daftarMakanan = daftarMakanan)
        }
        composable(
            "rincian/{makananId}",
            arguments = listOf(navArgument("makananId") { type = NavType.IntType })
        ) { backStackEntry ->
            val makananId = backStackEntry.arguments?.getInt("makananId") ?: 0
            DetailMakananBody(makananId = makananId, daftarMakanan = daftarMakanan)
        }
    }
}*/
