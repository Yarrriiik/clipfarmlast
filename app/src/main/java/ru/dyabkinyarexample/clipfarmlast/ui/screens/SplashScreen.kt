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
        delay(3000)
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0d0d0d)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "ClipFactory",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF7C5CFF)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Operator",
            fontSize = 24.sp,
            fontWeight = FontWeight.Light,
            color = Color(0xFF9FB0C0)
        )
    }
}
