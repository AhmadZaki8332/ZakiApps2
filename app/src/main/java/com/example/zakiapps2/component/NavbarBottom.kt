package com.example.zakiapps2.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.zakiapps2.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.zakiapps2.Routes


@Composable
fun NavbarBotom(navController: NavController) {
    BottomNavigationBar(navController)
}

data class BottomNavigation(
    val title: String,
    val iconRes: Int,
    val iconSelected: Int,
    val route: String
)

val items = listOf(
    BottomNavigation(
        title = "Beranda",
        iconRes = R.drawable.berandagakditekan,
        iconSelected = R.drawable.berandaditekan,
        route = Routes.BerandaActivity
    ),
    BottomNavigation(
        title = "Menu",
        iconRes = R.drawable.menugakditekan,
        iconSelected = R.drawable.menuditekan,
        route = Routes.MakananGridActivity
    ),
    BottomNavigation(
        title = "Profil",
        iconRes = R.drawable.profilgakditekan,
        iconSelected = R.drawable.profilditekan,
        route = Routes.ProfilActivity
    )
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route

    val customFontFamily = FontFamily(
        Font(R.font.medium, FontWeight.Medium)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFE8D3))
    ){
        NavigationBar(
            containerColor = Color(0xFFe02d39),
            modifier = Modifier
                .clip(RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp
                ))
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(
                                id = if (currentRoute == item.route) {
                                    item.iconSelected
                                } else {
                                    item.iconRes
                                }
                            ),
                            contentDescription = item.title,
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontFamily = customFontFamily,
                            color = Color.White,
                            fontWeight = if (currentRoute == item.route) {
                                FontWeight.Bold
                            } else {
                                FontWeight.Normal
                            },
                            fontSize = 12.sp
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent,
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White
                    ),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun preview() {
    BottomNavigationBar(navController = rememberNavController())

}
