package ru.dyabkinyarexample.clipfarmlast.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun StatusChip(status: String) {
    val backgroundColor = when (status) {
        "Ready" -> Color(0xFF4CAF50)      // Зеленый
        "Running" -> Color(0xFF2196F3)    // Синий
        "Error" -> Color(0xFFFF5252)      // Красный
        else -> Color(0xFFFFC107)          // Желтый (Queued)
    }

    AssistChip(
        onClick = {},
        label = { Text(status) },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = backgroundColor
        )
    )
}

@Composable
fun BottomNavBar(navController: NavController, currentRoute: String) {
    NavigationBar(containerColor = Color(0xFF1a1a1a)) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, "Проекты") },
            label = { Text("Проекты") },
            selected = currentRoute == "projects",
            onClick = { navController.navigate("projects") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, "Карта") },
            label = { Text("Карта") },
            selected = currentRoute == "server_selection",
            onClick = { navController.navigate("server_selection") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Settings, "Настройки") },
            label = { Text("Настройки") },
            selected = currentRoute == "settings",
            onClick = { navController.navigate("settings") }
        )
    }
}
