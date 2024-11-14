package com.example.zakiapps2.body

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zakiapps2.R
import com.example.zakiapps2.Routes

@Composable
fun ProfiBody(navController: NavController) {

    val customFontFamily = FontFamily(
        Font(R.font.medium, FontWeight.Medium),
        Font(R.font.bold, FontWeight.Bold)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item() {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFe02d39)),
                    shape = RoundedCornerShape(
                        bottomStart = 15.dp,
                        bottomEnd = 15.dp
                    )
                ) {
                    //buat tulisan profil dan icon setting
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, start = 20.dp, end = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Profil",
                            fontFamily = customFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,
                            color = Color.White
                        )
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

                //tarok sini foto nya
                Card(
                    modifier = Modifier
                        .size(230.dp)
                        .align(Alignment.BottomCenter),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFf5f5f5)),
                    shape = CircleShape
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.fotoaku),
                            contentDescription = "Foto Profil",
                            modifier = Modifier
                                .clip(shape = CircleShape)
                                .size(200.dp)
                        )
                    }
                }
            }

            // nama
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Ahmad Ghulam Zaki",
                    fontSize = 24.sp,
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 20.dp)
                )
            }

            //data diri lainnya

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                //buat email
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(R.drawable.email),
                        contentDescription = "logo email",
                        modifier = Modifier
                            .size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        "ahmadzaki8332@gmail.com",
                        fontSize = 18.sp,
                        fontFamily = customFontFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier

                    )
                }

                //buat asal kampus
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.universitas),
                        contentDescription = "logo email",
                        modifier = Modifier
                            .size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        "Politeknik Negeri Batam",
                        fontSize = 18.sp,
                        fontFamily = customFontFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier

                    )
                }

                //buat jurusan
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.jurusan),
                        contentDescription = "logo email",
                        modifier = Modifier
                            .size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        "Teknik Informatika",
                        fontSize = 18.sp,
                        fontFamily = customFontFamily,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier

                    )
                }

                val uriHandler = LocalUriHandler.current
                val url = "https://www.instagram.com/ahmdzki.10/profilecard/?igsh=MWZjbHRsMWwwamlpNQ=="

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.width(10.dp))
                    ClickableText(
                        text = AnnotatedString(
                            text = "Instagram Profile",
                            spanStyle = androidx.compose.ui.text.SpanStyle(
                                color = Color.Black,
                                fontSize = 18.sp,
                                textDecoration = TextDecoration.Underline
                            )
                        ),
                        onClick = {
                            uriHandler.openUri(url)
                        }
                    )
                }





            }
        }
    }
}