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

data class ConfigOption(
    val icon: String,
    val label: String
)

val configOptions = listOf(
    ConfigOption("⚙️", "Формат экспорта"),
    ConfigOption("⚙️", "Битрейт"),
    ConfigOption("⚙️", "Субтитры"),
    ConfigOption("⚙️", "Удаление тишины"),
    ConfigOption("⚙️", "Брендинг баннера")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigurationScreen(navController: NavController) {
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
                    text = "Конфигурация",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Подзаголовок
            item {
                Text(
                    text = "Выбор параметра конфигурации",
                    fontSize = 16.sp,
                    color = Color(0xFFB0B0B0)
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Список опций конфигурации
            items(configOptions) { option ->
                ConfigOptionItem(
                    icon = option.icon,
                    label = option.label
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
private fun ConfigOptionItem(
    icon: String,
    label: String
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { /* Выбор опции */ },
        color = Color(0xFF1a1a1a),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(icon, fontSize = 20.sp)
            Text(
                label,
                fontSize = 14.sp,
                color = Color(0xFFB0B0B0),
                modifier = Modifier.weight(1f)
            )
        }
    }
}
