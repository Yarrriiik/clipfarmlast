package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.dyabkinyarexample.clipfarmlast.ui.theme.ClipfarlastTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonitoringScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Мониторинг") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1a1a1a),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0d0d0d))
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Статус серверов",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )

            // Пример карточки сервера
            ServerStatusCard(
                name = "Сервер 1",
                status = "Активен",
                load = "45%",
                statusColor = Color.Green
            )
            ServerStatusCard(
                name = "Сервер 2",
                status = "Активен",
                load = "72%",
                statusColor = Color.Green
            )
            ServerStatusCard(
                name = "Сервер 3",
                status = "Неактивен",
                load = "0%",
                statusColor = Color.Red
            )
        }
    }
}

@Composable
private fun ServerStatusCard(
    name: String,
    status: String,
    load: String,
    statusColor: Color
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        color = Color(0xFF1a1a1a),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(name, color = Color.White, style = MaterialTheme.typography.bodyLarge)
                Text(
                    "Статус: $status",
                    color = statusColor,
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    "Нагрузка: $load",
                    color = Color(0xFF888888),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
