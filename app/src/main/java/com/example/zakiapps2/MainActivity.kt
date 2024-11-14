package com.example.zakiapps2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.zakiapps2.view.BerandaActivity
import androidx.navigation.compose.rememberNavController
import com.example.zakiapps2.view.DetailMakananActivity
import com.example.zakiapps2.view.DetailMakananGridActivity
import com.example.zakiapps2.view.DetailRestoranActivity
import com.example.zakiapps2.view.KeranjangActivity
import com.example.zakiapps2.view.MakananGridActivity
import com.example.zakiapps2.view.ProfilActivity
import com.example.zakiapps2.view.SettingActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.BerandaActivity) {
                composable(Routes.BerandaActivity) {
                    BerandaActivity(navController = navController)
                }
                composable("DetailMakananActivity/{makananId}") { backStackEntry ->
                    val makananId = backStackEntry.arguments?.getString("makananId")?.toInt() ?: 0
                    DetailMakananActivity(navController = navController, makananId = makananId)
                }
                composable("DetailRestoranActivity/{restoranId}") { backStackEntry ->
                    val restoranId = backStackEntry.arguments?.getString("restoranId")?.toInt() ?: 0
                    DetailRestoranActivity(navController = navController, restoranId = restoranId)
                }
                composable(Routes.MakananGridActivity) {
                    MakananGridActivity(navController = navController)
                }
                composable("DetailMakananGridActivity/{makanangridId}") { backStackEntry ->
                    val makanangridId = backStackEntry.arguments?.getString("makanangridId")?.toInt() ?: 0
                    DetailMakananGridActivity(navController = navController, makanangridId = makanangridId)
                }
                composable(Routes.ProfilActivity) {
                    ProfilActivity(navController = navController)
                }
                composable(Routes.KeranjangActivity) {
                    KeranjangActivity(navController = navController)
                }
                composable(Routes.SettingActivity) {
                    SettingActivity(navController = navController)
                }



            }
        }
    }
}


