package ru.dyabkinyarexample.clipfarmlast.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.dyabkinyarexample.clipfarmlast.ClipFarmApplication
import ru.dyabkinyarexample.clipfarmlast.viewmodel.AuthViewModel
import ru.dyabkinyarexample.clipfarmlast.viewmodel.AuthViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController, userEmail: String) {
    val context = LocalContext.current
    val application = context.applicationContext as ClipFarmApplication
    val authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory(application))

    var newPassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var successMessage by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Настройки аккаунта") },
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
            Text("Изменить пароль", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)

            OutlinedTextField(
                value = newPassword,
                onValueChange = { newPassword = it },
                label = { Text("Новый пароль", color = Color.White) },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF00D4FF),
                    unfocusedBorderColor = Color(0xFF333333),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            if (errorMessage.isNotEmpty()) {
                Text(errorMessage, color = Color.Red)
            }
            if (successMessage.isNotEmpty()) {
                Text(successMessage, color = Color.Green)
            }

            Button(
                onClick = {
                    if (newPassword.isNotBlank()) {
                        isLoading = true
                        authViewModel.updatePassword(userEmail, newPassword) { success, message ->
                            isLoading = false
                            if (success) {
                                successMessage = message
                                newPassword = ""
                            } else {
                                errorMessage = message
                            }
                        }
                    } else {
                        errorMessage = "Введите новый пароль"
                    }
                },
                enabled = !isLoading,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00D4FF))
            ) {
                Text("Изменить пароль", color = Color(0xFF141718))
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    isLoading = true
                    authViewModel.deleteUser(userEmail) { success, message ->
                        isLoading = false
                        if (success) {
                            navController.navigate("login") {
                                popUpTo("login") { inclusive = true }
                            }
                        } else {
                            errorMessage = message
                        }
                    }
                },
                enabled = !isLoading,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Удалить аккаунт", color = Color.White)
            }

            // Кнопка выход
            Button(
                onClick = {
                    navController.navigate("login") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text("Выход", color = Color.White)
            }


            // Старые настройки приложения (если хочешь оставить)
            Spacer(modifier = Modifier.height(32.dp))
            Text("Параметры приложения", style = MaterialTheme.typography.headlineSmall, color = Color.White)
            SettingItem(title = "Тема", value = "Темная")
            SettingItem(title = "Язык", value = "Русский")
            SettingItem(title = "Уведомления", value = "Включены")
            SettingItem(title = "Версия приложения", value = "1.0.0")
        }
    }
}

@Composable
private fun SettingItem(title: String, value: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        color = Color(0xFF1a1a1a),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, color = Color.White, style = MaterialTheme.typography.bodyLarge)
            Text(value, color = Color(0xFF888888), style = MaterialTheme.typography.bodySmall)
        }
    }
}
