package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen2(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141718))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Заголовок
        Text(
            text = "Войдите в свою\nучетную запись",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Email поле с иконкой
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = null, tint = Color(0xFF00D4FF)) },
            placeholder = { Text("yorrik@gmail.com", color = Color(0xFF666666)) },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF00D4FF),
                unfocusedBorderColor = Color(0xFF333333),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        )

        // Password поле с иконкой
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null, tint = Color(0xFF00D4FF)) },
            placeholder = { Text("••••••••••", color = Color(0xFF666666)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF00D4FF),
                unfocusedBorderColor = Color(0xFF333333),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // "Forget Password ?" ссылка
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Forget Password ?",
                fontSize = 12.sp,
                color = Color(0xFF00D4FF),
                modifier = Modifier.clickable { /* навигация на восстановление пароля */ }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Кнопка "Войти"
        Button(
            onClick = { navController.navigate("projects") { popUpTo("login") { inclusive = true } } },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00D4FF)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Войти", color = Color(0xFF141718), fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Ссылка на регистрацию
        Text(
            text = "Создать новый аккаунт? Зарегистрироваться",
            fontSize = 12.sp,
            color = Color(0xFF888888),
            modifier = Modifier.clickable { /* навигация на регистрацию */ }
        )

        Spacer(modifier = Modifier.height(30.dp))

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
    }
}
