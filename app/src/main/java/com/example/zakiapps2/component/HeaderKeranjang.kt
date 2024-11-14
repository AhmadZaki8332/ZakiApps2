package com.example.zakiapps2.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.zakiapps2.model.Makanan

@Composable
fun HeaderKeranjang(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.medium, FontWeight.Medium),
        Font(R.font.bold, FontWeight.Bold)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(
                bottomEnd = 15.dp,
                bottomStart = 15.dp
            ))
            .background(Color(0xFFe02d39))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
            ){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Kembali",
                    tint = Color.White,
                    modifier = Modifier
                        .clickable() {
                            navController.popBackStack()
                        }
                        .padding(end = 5.dp)
                )
                Text(
                    "Pesanan Anda",
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Icon(
                painter = painterResource(R.drawable.pengaturanm),
                contentDescription = "icon pengeturan",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        navController.navigate(Routes.SettingActivity)
                    },
                tint = Color.White
            )
        }
    }
}