package com.example.zakiapps2.body

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zakiapps2.R
import com.example.zakiapps2.model.Makanan
import com.example.zakiapps2.model.Restoran

@Composable
fun KeranjangBody(navController: NavController) {

    val customFontFamily = FontFamily(
        Font(R.font.medium, FontWeight.Medium),
        Font(R.font.bold, FontWeight.Bold)
    )
    Column {
        Card(
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .shadow(
                    elevation = 12.dp,
                    ambientColor = Color.Black.copy(alpha = 0.2f),
                    spotColor = Color.Black.copy(alpha = 0.5f)
                ),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row {
                    Image(
                        painter = painterResource(R.drawable.mieayam),
                        contentDescription = "gambar Mie Ayam",
                        modifier = Modifier
                            .width(100.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Mie Ayam",
                            fontSize = 18.sp,
                            fontFamily = customFontFamily,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "12.000",
                            fontSize = 18.sp,
                            fontFamily = customFontFamily
                        )
                        Text(
                            text = "Sajian Nusantara",
                            fontSize = 16.sp,
                            fontFamily = customFontFamily
                        )

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Icon(
                                painter = painterResource(R.drawable.location),
                                contentDescription = "icon lokasi",
                                modifier = Modifier
                                    .size(26.dp)
                                    .padding(end = 5.dp)
                            )
                            Text(
                                text = "Batam Center",
                                fontFamily = customFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                .shadow(
                    elevation = 12.dp,
                    ambientColor = Color.Black.copy(alpha = 0.2f),
                    spotColor = Color.Black.copy(alpha = 0.5f)
                ),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row {
                    Image(
                        painter = painterResource(R.drawable.bakso),
                        contentDescription = "gambar Bakso",
                        modifier = Modifier
                            .width(100.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Bakso",
                            fontSize = 18.sp,
                            fontFamily = customFontFamily,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "12.000",
                            fontSize = 18.sp,
                            fontFamily = customFontFamily
                        )
                        Text(
                            text = "Nusa Terra",
                            fontSize = 16.sp,
                            fontFamily = customFontFamily
                        )

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                            verticalAlignment = Alignment.CenterVertically

                        ) {
                            Icon(
                                painter = painterResource(R.drawable.location),
                                contentDescription = "icon lokasi",
                                modifier = Modifier
                                    .size(26.dp)
                                    .padding(end = 5.dp)
                            )
                            Text(
                                text = "Batam Center",
                                fontFamily = customFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}
