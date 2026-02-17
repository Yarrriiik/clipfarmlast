package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141718))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        // Заголовок
        Text(
            text = "Добро\nпожаловать в\nClipFactory",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.height(100.dp))

        // Подзаголовок
        Text(
            text = "Вход в учетную запись",
            fontSize = 16.sp,
            color = Color(0xFFB0B0B0),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        // Кнопка "Войти"
        Button(
            onClick = { navController.navigate("login2") },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF374151)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Войти", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Текст "Продолжить с помощью аккаунта"
        Text(
            text = "Продолжить с помощью аккаунта",
            fontSize = 12.sp,
            color = Color(0xFF888888)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Кнопки Google и Facebook
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(44.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB94E4E)),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text("GOOGLE", fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(44.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B5998)),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text("FACEBOOK", fontSize = 12.sp, color = Color.White, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}
