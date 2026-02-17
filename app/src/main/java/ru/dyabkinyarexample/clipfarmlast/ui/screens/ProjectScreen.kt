package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.dyabkinyarexample.clipfarmlast.model.sampleProjects
import ru.dyabkinyarexample.clipfarmlast.ui.components.BottomNavBar
import ru.dyabkinyarexample.clipfarmlast.ui.components.StatusChip

@Composable
fun ProjectsScreen(navController: NavController) {
    Scaffold(
        containerColor = Color(0xFF0d0d0d),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("new_project") },
                containerColor = Color(0xFF00D4FF)
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Новый проект")
            }
        },
        bottomBar = { BottomNavBar(navController, "projects") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0d0d0d))
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text("Проекты", fontSize = 24.sp, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(sampleProjects) { project ->
                    ProjectCard(project, navController)
                }
            }
        }
    }
}

@Composable
fun ProjectCard(project: ru.dyabkinyarexample.clipfarmlast.model.Project, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("monitoring") }
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1a1a1a))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(project.name, fontSize = 16.sp, color = Color.White)
                StatusChip(project.status)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "${project.clipsCount} клипов · ${project.duration}",
                fontSize = 12.sp,
                color = Color(0xFF888888)
            )
            Text(
                "Обновлено: ${project.createdAt}",
                fontSize = 11.sp,
                color = Color(0xFF666666)
            )
        }
    }
}
