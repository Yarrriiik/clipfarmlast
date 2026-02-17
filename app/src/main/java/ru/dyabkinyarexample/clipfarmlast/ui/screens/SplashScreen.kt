package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(1000) //3000 БЫЛО
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141718)),  // Цвет фона из Figma
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Основной заголовок
        Text(
            text = "ClipFactory",
            fontSize = 35.sp,  // Размер из Figma
            fontWeight = FontWeight.Medium,  // Вес из Figma
            color = Color(0xFFFFFFFF)  // Белый цвет из Figma
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Подзаголовок
        Text(
            text = "Version 1.0 панель операторов",
            fontSize = 18.sp,  // Примерный размер
            fontWeight = FontWeight.Light,  // Light вес из Figma
            color = Color(0xFF757171)  // Серый цвет из Figma
        )
    }
}
