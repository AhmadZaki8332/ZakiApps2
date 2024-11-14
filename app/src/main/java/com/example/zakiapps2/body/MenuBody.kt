package com.example.zakiapps2.body

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.zakiapps2.model.MakananGrid
import com.example.zakiapps2.data.daftarMakananGrid
import com.example.zakiapps2.model.Restoran
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.ui.Alignment
import com.example.zakiapps2.Routes

@Composable
fun MenuBody(navController: NavController,
             daftarMakananGrid: List<MakananGrid>) {

    val customFontFamily = FontFamily(
        Font(R.font.medium, FontWeight.Medium),
        Font(R.font.bold, FontWeight.Bold)
    )

    val isFilterClicked = remember { mutableStateOf(false) }
    val isHargaClicked = remember { mutableStateOf(false) }
    val isJarakClicked = remember { mutableStateOf(false) }

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
                    .padding(20.dp)
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    //card filter
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .shadow(
                                elevation = 12.dp,
                                ambientColor = Color.Black.copy(alpha = 0.2f),
                                spotColor = Color.Black.copy(alpha = 0.5f)
                            )
                            .clickable {isFilterClicked.value = !isFilterClicked.value},
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(containerColor =
                        if (isFilterClicked.value) Color(0xFFe02d39) else Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.filter),
                                contentDescription = "icon filter",
                                modifier = Modifier
                                    .size(16.dp),
                                tint = if (isFilterClicked.value) Color.White else Color.Black
                            )
                            Text(
                                "Filter",
                                modifier = Modifier
                                    .padding(start = 5.dp),
                                fontFamily = customFontFamily,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = if (isFilterClicked.value) Color.White else Color.Black
                            )
                        }
                    }

                    //card harga
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .shadow(
                                elevation = 12.dp,
                                ambientColor = Color.Black.copy(alpha = 0.2f),
                                spotColor = Color.Black.copy(alpha = 0.5f)
                            )
                            .clickable {isHargaClicked.value = !isHargaClicked.value},
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(containerColor =
                        if (isHargaClicked.value) Color(0xFFe02d39) else Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                    ) {
                        Text(
                            "Harga",
                            modifier = Modifier
                                .padding(10.dp)
                                .align(Alignment.CenterHorizontally),
                            fontWeight = FontWeight.Medium,
                            fontFamily = customFontFamily,
                            fontSize = 16.sp,
                            color = if (isHargaClicked.value) Color.White else Color.Black
                        )
                    }

                    //card jarak
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .shadow(
                                elevation = 12.dp,
                                ambientColor = Color.Black.copy(alpha = 0.2f),
                                spotColor = Color.Black.copy(alpha = 0.5f)
                            )
                            .clickable { isJarakClicked.value = !isJarakClicked.value},
                        shape = RoundedCornerShape(10.dp),
                        colors = CardDefaults.cardColors(containerColor =
                        if (isJarakClicked.value) Color(0xFFe02d39) else Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                    ) {
                        Text(
                            "Jarak",
                            modifier = Modifier
                                .padding(10.dp)
                                .align(Alignment.CenterHorizontally),
                            fontWeight = FontWeight.Medium,
                            fontFamily = customFontFamily,
                            fontSize = 16.sp,
                            color = if (isJarakClicked.value) Color.White else Color.Black
                        )
                    }
                }
            }

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(160.dp),
                verticalItemSpacing = 10.dp,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
            ) {
                items(daftarMakananGrid) { makanangrid ->
                    DataMakananGrid(makanangrid = makanangrid, onClick = {
                        navController.navigate("DetailMakananGridActivity/${makanangrid.id}")
                    })
                }
            }

        }
    }
}

@Composable
fun DataMakananGrid(makanangrid: MakananGrid, onClick: () -> Unit) {
    val customFontFamily = FontFamily(
        Font(R.font.medium, FontWeight.Medium),
        Font(R.font.bold, FontWeight.Bold)
    )

    Card(
        modifier = Modifier
            .clickable{ onClick() }
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
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(makanangrid.gambar),
                contentDescription = makanangrid.nama,
                modifier = Modifier
                    .wrapContentHeight()
                    .clip(
                        RoundedCornerShape(
                            topStart = 5.dp,
                            topEnd = 5.dp
                        )
                    ),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = makanangrid.nama,
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
                Text(
                    text = "||",
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
                Text(
                    text = makanangrid.harga,
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
            }
        }
    }
}