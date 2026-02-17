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

data class FullProjectItem(
    val name: String,
    val date: String,
    val progress: String,
    val icon: String
)

val fullProjects = listOf(
    FullProjectItem("Бесстыжие", "26.11.2025", "10/15", "👥"),
    FullProjectItem("Форс-мажоры", "21.11.2025", "5/8", "⚡"),
    FullProjectItem("Побег", "19.11.2025", "11/19", "🏃"),
    FullProjectItem("Сотня", "20.11.2025", "10/15", "🎬"),
    FullProjectItem("Танки", "21.11.2025", "5/8", "🚗"),
    FullProjectItem("Форсаж", "19.11.2025", "11/19", "🏎️")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullProjectsScreen(navController: NavController) {
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
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Заголовок
            item {
                Text(
                    text = "Проекты",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Список проектов
            items(fullProjects) { project ->
                FullProjectCard(project, navController)
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }

            // Кнопка "Создать новый проект"
            item {
                Button(
                    onClick = { navController.navigate("new_project") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00D4FF)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        "Создать новый проект",
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
private fun FullProjectCard(project: FullProjectItem, navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("monitoring") }
            .padding(8.dp),
        color = Color(0xFF1a1a1a),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(project.icon, fontSize = 24.sp)
                    Column {
                        Text(
                            project.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            project.date,
                            fontSize = 12.sp,
                            color = Color(0xFF888888)
                        )
                    }
                }
            }

            Text(
                project.progress,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF00D4FF)
            )
        }
    }
}
