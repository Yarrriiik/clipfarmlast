package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewProjectScreen(navController: NavController) {
    var projectName by remember { mutableStateOf("") }
    var bannerType by remember { mutableStateOf("Top") }
    var filmUrl by remember { mutableStateOf("") }
    var clipDuration by remember { mutableStateOf("45-120") }
    var clipCount by remember { mutableStateOf("5-15") }

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
                    text = "Ваш новый проект",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Подзаголовок
            item {
                Text(
                    text = "Введите пресет",
                    fontSize = 16.sp,
                    color = Color(0xFFB0B0B0)
                )
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }

            // Поле 1: Название проекта
            item {
                ProjectInputField(
                    icon = "⚙️",
                    label = "Название проекта: name",
                    value = projectName,
                    onValueChange = { projectName = it }
                )
            }

            // Поле 2: Тип баннера
            item {
                ProjectInputField(
                    icon = "⚙️",
                    label = "Тип баннера: Top / Bottom",
                    value = bannerType,
                    onValueChange = { bannerType = it }
                )
            }

            // Поле 3: Ссылка на фильм
            item {
                ProjectInputField(
                    icon = "⚙️",
                    label = "Ссылка на фильме / сервал: url",
                    value = filmUrl,
                    onValueChange = { filmUrl = it }
                )
            }

            // Поле 4: Среднее время клипа
            item {
                ProjectInputField(
                    icon = "⚙️",
                    label = "Среднее время клипа: 45-120 сек",
                    value = clipDuration,
                    onValueChange = { clipDuration = it }
                )
            }

            // Поле 5: Количество клипов
            item {
                ProjectInputField(
                    icon = "⚙️",
                    label = "Количество клипов: 5-15 шт",
                    value = clipCount,
                    onValueChange = { clipCount = it }
                )
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }

            // Кнопка "Запустить генерацию"
            item {
                Button(
                    onClick = { navController.navigate("full_projects") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00D4FF)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        "Запустить генерацию",
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
private fun ProjectInputField(
    icon: String,
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
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
