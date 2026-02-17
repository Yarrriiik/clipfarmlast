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

data class SettingOption(
    val icon: String,
    val label: String
)

val settingOptions = listOf(
    SettingOption("⚙️", "Проекты"),
    SettingOption("⚙️", "Изменение конфигурации проекта"),
    SettingOption("⚙️", "Нагрузка серверов"),
    SettingOption("⚙️", "Выбор серверов"),
    SettingOption("⚙️", "Остаток на балансе")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsProjectScreen(navController: NavController) {
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
                    text = "Выбор категории",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Подзаголовок
            item {
                Text(
                    text = "Введите необходимое",
                    fontSize = 16.sp,
                    color = Color(0xFFB0B0B0)
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Список опций
            items(settingOptions) { option ->
                SettingsOptionItem(
                    icon = option.icon,
                    label = option.label,
                    onClick = {
                        when (option.label) {
                            "Проекты" -> navController.navigate("full_projects")
                            "Изменение конфигурации проекта" -> navController.navigate("configuration")
                            "Нагрузка серверов" -> navController.navigate("server_load")
                            "Выбор серверов" -> navController.navigate("server_processing")
                            "Остаток на балансе" -> navController.navigate("card_balance")

                            "Нагрузка серверов" -> navController.navigate("server_selection")
                            else -> { /* Другие переходы */ }
                        }
                    }
                )
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
private fun SettingsOptionItem(
    icon: String,
    label: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { onClick() },
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
