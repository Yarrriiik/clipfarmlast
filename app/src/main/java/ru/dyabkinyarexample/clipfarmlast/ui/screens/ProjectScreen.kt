package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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

data class ProjectItem(
    val name: String,
    val date: String,
    val progress: String,
    val icon: String
)

val sampleProjects = listOf(
    ProjectItem("Бесстыжие", "26.11.2025", "10/15", "👥"),
    ProjectItem("Форс-мажоры", "21.11.2025", "5/8", "⚡"),
    ProjectItem("Побег", "19.11.2025", "11/19", "🏃")
)

@Composable
fun ProjectsScreen(navController: NavController,userEmail: String) {
    Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF141718))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
        // Основной контент
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Profile карточка - большая, с изображением справа
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp),
                    color = Color(0xFF141718),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Текст слева
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "profile",
                                fontSize = 12.sp,
                                color = Color(0xFF888888)
                            )
                            Text(
                                text = "Yarriik",
                                fontSize = 24.sp,  // Уменьши размер, чтобы поместилось
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = userEmail,
                                fontSize = 14.sp,
                                color = Color(0xFF888888)
                            )
                        }


                        // Изображение справа (большое)
                        Surface(
                            modifier = Modifier
                                .size(120.dp)
                                .clickable { /* Открыть профиль */ },
                            color = Color(0xFF1a1a1a),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image02),
                                contentDescription = "Profile Avatar",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            }

            // Последние проекты - заголовок
            item {
                Text(
                    text = "Последние проекты",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Список проектов
            items(sampleProjects) { project ->
                ProjectCard(project, navController)
            }

            // Первая кнопка - "Управление проектами"
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { navController.navigate("settings_project") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF374151)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        "Управление проектами",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Вторая кнопка - "Создать новый проект"
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
                Button(
                    onClick = { navController.navigate("settings/$userEmail") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00D4FF))
                ) {
                   Text("Настройки аккаунта", color = Color(0xFF141718))
                }
                // Кнопка "Выход"
                Button(
                    onClick = {
                        navController.navigate("login") {
                            popUpTo("login") { inclusive = true }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text("Выход", color = Color.White)
                }
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun ProjectCard(project: ProjectItem, navController: NavController) {
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
