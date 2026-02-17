package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class ServerOption(
    val icon: String,
    val name: String,
    val details: String
)

val serverOptions = listOf(
    ServerOption("⚙️", "EU-West (Amsterdam)", "Цена: $0.42/мин; Скорость: ~1k (быстро); Пинг: ~35ms"),
    ServerOption("⚙️", "EU-Central (Frankfurt)", "Цена: $0.39/мин; Скорость: ~1.0k (быстро); Пинг: ~45ms"),
    ServerOption("⚙️", "ES-East (Virginia)", "Цена: $0.33/мин; Скорость: ~1.2k (пинг: ~90ms)"),
    ServerOption("⚙️", "ES-West (Singapore)", "Цена: $0.45/мин; Скорость: ~1.0k (пинг: ~180ms)"),
    ServerOption("⚙️", "Asia-Tokyo", "Цена: $0.52/мин; Скорость: ~1.35k; Пинг: ~220ms")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServerReplacementScreen(navController: NavController) {
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
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Назад", tint = Color.White)
            }
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
                    text = "Выберите регион\nсервера обработки",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Подзаголовок
            item {
                Text(
                    text = "Нажмите для выбора",
                    fontSize = 16.sp,
                    color = Color(0xFFB0B0B0)
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Список серверов
            items(serverOptions) { server ->
                ServerOptionItem(
                    server = server,
                    onClick = { navController.popBackStack() }
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
private fun ServerOptionItem(
    server: ServerOption,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp),
        color = Color(0xFF1a1a1a),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(server.icon, fontSize = 20.sp)
                Text(
                    server.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
            }
            Text(
                server.details,
                fontSize = 12.sp,
                color = Color(0xFF888888),
                lineHeight = 16.sp
            )
        }
    }
}
