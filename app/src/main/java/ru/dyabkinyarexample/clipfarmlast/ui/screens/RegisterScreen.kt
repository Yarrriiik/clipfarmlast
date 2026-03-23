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
import androidx.compose.runtime.LaunchedEffect
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

@Composable
fun RegisterScreen(navController: NavController) {
    val context = LocalContext.current
    val application = context.applicationContext as ClipFarmApplication
    val authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory(application))

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var successMessage by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        errorMessage = ""
        successMessage = ""
    }

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
            text = "Регистрация\nнового аккаунта",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Email поле
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

        // Password поле
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

        // Confirm Password поле
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
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

        // Error message
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        // Success message
        if (successMessage.isNotEmpty()) {
            Text(
                text = successMessage,
                color = Color.Green,
                fontSize = 14.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Кнопка "Зарегистрироваться"
        Button(
            onClick = {
                if (email.isNotBlank() && password.isNotBlank() && confirmPassword.isNotBlank()) {
                    if (password == confirmPassword) {
                        isLoading = true
                        authViewModel.register(email, password) { success, message ->
                            isLoading = false
                            if (success) {
                                successMessage = message
                                // Optionally navigate back to login
                                navController.popBackStack()
                            } else {
                                errorMessage = message
                            }
                        }
                    } else {
                        errorMessage = "Passwords do not match"
                    }
                } else {
                    errorMessage = "Please fill in all fields"
                }
            },
            enabled = !isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00D4FF)),
            shape = RoundedCornerShape(8.dp)
        ) {
            if (isLoading) {
                CircularProgressIndicator(color = Color(0xFF141718), modifier = Modifier.size(20.dp))
            } else {
                Text("Зарегистрироваться", color = Color(0xFF141718), fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Ссылка на вход
        Text(
            text = "Уже есть аккаунт? Войти",
            fontSize = 12.sp,
            color = Color(0xFF888888),
            modifier = Modifier.clickable { navController.popBackStack() }
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}
