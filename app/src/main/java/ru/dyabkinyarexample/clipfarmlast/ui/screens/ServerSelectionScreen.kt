package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ServerSelectionScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0d0d0d))
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Выбор сервера", fontSize = 24.sp, color = Color.White)

        // Пример карточки сервера
        ServerCard(name = "Москва", location = "194.126.X.X", load = "45%")
        ServerCard(name = "Санкт-Петербург", location = "212.193.X.X", load = "62%")
        ServerCard(name = "Екатеринбург", location = "196.240.X.X", load = "38%")
    }
}

@Composable
private fun ServerCard(name: String, location: String, load: String) {
    androidx.compose.material3.Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        color = Color(0xFF1a1a1a),
        shape = androidx.compose.material3.MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(name, fontSize = 16.sp, color = Color.White)
            Text(location, fontSize = 12.sp, color = Color(0xFF888888))
            Text("Нагрузка: $load", fontSize = 12.sp, color = Color(0xFF666666))
        }
    }
}
