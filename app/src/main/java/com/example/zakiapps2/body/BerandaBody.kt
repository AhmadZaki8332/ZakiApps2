package com.example.zakiapps2.body

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zakiapps2.R
import androidx.compose.foundation.Image
import androidx.compose.material3.contentColorFor
import com.example.zakiapps2.component.items
import com.example.zakiapps2.model.Makanan
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import com.example.zakiapps2.Routes
import com.example.zakiapps2.data.daftarRestoran
import com.example.zakiapps2.model.MakananGrid
import com.example.zakiapps2.model.Restoran
import java.nio.file.WatchEvent


@Composable
fun BerandaBody(navController: NavController,
                daftarMakanan: List<Makanan>,
                daftarRestoran: List<Restoran>) {

    val customFontFamily = FontFamily(
        Font(R.font.medium, FontWeight.Medium),
        Font(R.font.bold, FontWeight.Bold)
    )

    var kolomSearch by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 10.dp)
                    .height(IntrinsicSize.Min)
            ) {
                TextField(
                    value = kolomSearch,
                    onValueChange = { kolomSearch = it },
                    singleLine = true,
                    modifier = Modifier
                        .shadow(
                            4.dp,
                            RoundedCornerShape(10.dp)
                        ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    placeholder = { Text(text = "Cari") }
                )

                Spacer(modifier = Modifier.width(15.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clickable {
                            navController.navigate(Routes.KeranjangActivity)
                        },
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.keranjang),
                            contentDescription = "Icon keranjang",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    Text(
                        text = "Menu Favorit",
                        modifier = Modifier
                            .padding(start = 20.dp),
                        fontFamily = customFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }

                item {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        item {
                            Spacer(modifier = Modifier.width(7.dp))
                        }

                        items(daftarMakanan) { makanan ->
                            DataMakanan(makanan = makanan, onClick = {
                                navController.navigate("DetailMakananActivity/${makanan.id}")
                            })
                        }

                        item {
                            Spacer(modifier = Modifier.width(7.dp))
                        }
                    }
                }

                item {
                    Text(
                        text = "Restoran Terdekat",
                        modifier = Modifier
                            .padding(start = 20.dp, top = 20.dp),
                        fontFamily = customFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(10.dp))
                }

                items(daftarRestoran) { restoran ->
                    DataRestoran(restoran = restoran, onClick = {
                        navController.navigate("DetailRestoranActivity/${restoran.id}")
                    })
                }
            }
        }
    }
}

@Composable
fun DataMakanan(makanan: Makanan, onClick: () -> Unit) {
    val customFontFamily = FontFamily(
        Font(R.font.medium, FontWeight.Medium),
        Font(R.font.bold, FontWeight.Bold)
    )

    Card(
        modifier = Modifier
            .clickable { onClick() }
            .shadow(
                elevation = 12.dp,
                ambientColor = Color.Black.copy(alpha = 0.2f),
                spotColor = Color.Black.copy(alpha = 0.5f)
            ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(makanan.gambar),
                contentDescription = makanan.nama,
                modifier = Modifier
                    .size(125.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 5.dp,
                            topEnd = 5.dp
                        )
                    ),
            )
            Text(
                text = makanan.rating,
                fontFamily = customFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
            Text(
                text = makanan.nama,
                fontFamily = customFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Color.Black
            )
            Text(
                text = makanan.harga,
                fontFamily = customFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun DataRestoran(restoran: Restoran, onClick: () -> Unit) {
    val customFontFamily = FontFamily(
        Font(R.font.medium, FontWeight.Medium),
        Font(R.font.bold, FontWeight.Bold)
    )

    Card(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(start = 20.dp, bottom = 10.dp, end = 20.dp)
            .shadow(
                elevation = 12.dp,
                ambientColor = Color.Black.copy(alpha = 0.2f),
                spotColor = Color.Black.copy(alpha = 0.5f)
            ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(restoran.gambar),
                contentDescription = "gambar restoran",
                modifier = Modifier
                    .width(150.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 5.dp,
                            bottomStart = 5.dp
                        )
                    ),
            )
            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = restoran.nama,
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = restoran.rating,
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(top = 5.dp)
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
                        text = restoran.lokasi,
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


