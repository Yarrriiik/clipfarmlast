package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.dyabkinyarexample.clipfarmlast.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServerLoadScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0d0d0d))
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF141718))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Назад", tint = Color.White)
            }
            Text("Server", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(48.dp))
        }

        // Основной контент
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Заголовок
            item {
                Text(
                    text = "Нагрузка серверов",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Welcome & Help кнопка
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Welcome, Rp!",
                        fontSize = 14.sp,
                        color = Color(0xFFB0B0B0)
                    )
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .height(28.dp)
                            .width(60.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7C5CFF)),
                        contentPadding = PaddingValues(4.dp)
                    ) {
                        Text("? here", fontSize = 11.sp, color = Color.White)
                    }
                }
            }

            // Usage раздел с изображением
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF1a1a1a), RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        "Usage",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        "Keep an eye on your daily spend with real-time insights.",
                        fontSize = 12.sp,
                        color = Color(0xFF888888)
                    )

                    // Вставляем изображение график
                    Image(
                        painter = painterResource(id = R.drawable.image05_3),
                        contentDescription = "Usage Chart",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        contentScale = ContentScale.Crop
                    )

                    // Usage информация
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("$0.10", fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.Bold)
                            Text("/day", fontSize = 10.sp, color = Color(0xFF888888))
                        }
                        Column {
                            Text("$0.00", fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.Bold)
                            Text("/m", fontSize = 10.sp, color = Color(0xFF888888))
                        }
                    }
                }
            }

            // Resources раздел
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF1a1a1a), RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        "Resources",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        "Monitor your GPU, CPU, storage, and endpoint usage.",
                        fontSize = 12.sp,
                        color = Color(0xFF888888)
                    )

                    // Ресурсы сетка
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        ResourceItem("GPUs", "0", Modifier.weight(1f))
                        ResourceItem("vGPUs", "0", Modifier.weight(1f))
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        ResourceItem("Storage", "0 GB", Modifier.weight(1f))
                        ResourceItem("Endpoints", "2", Modifier.weight(1f))
                    }
                }
            }

            // Recent Endpoints раздел
            item {
                Text(
                    "Recent Endpoints",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    "Your recently deployed endpoints.",
                    fontSize = 12.sp,
                    color = Color(0xFF888888)
                )
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }

            // Кнопка "Обновить конфигурацию"
            item {
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00D4FF)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        "Обновить конфигурацию",
                        color = Color(0xFF141718),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun ResourceItem(label: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(0xFF0d0d0d), RoundedCornerShape(6.dp))
            .padding(12.dp)
    ) {
        Text(label, fontSize = 11.sp, color = Color(0xFF888888))
        Text(value, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
    }
}
