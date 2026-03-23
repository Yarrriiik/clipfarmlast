package ru.dyabkinyarexample.clipfarmlast.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.dyabkinyarexample.clipfarmlast.ClipFarmApplication
import ru.dyabkinyarexample.clipfarmlast.data.User

class AuthViewModel(private val application: ClipFarmApplication) : ViewModel() {

    fun register(email: String, password: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            val existingUser = application.database.userDao().getUserByEmail(email)
            if (existingUser != null) {
                onResult(false, "Email already exists")
            } else {
                val user = User(email = email, password = password)
                application.database.userDao().insertUser(user)
                onResult(true, "Registration successful")
            }
        }
    }

    fun login(email: String, password: String, onResult: (Boolean, String) -> Unit) {
        viewModelScope.launch {
            val user = application.database.userDao().getUserByEmailAndPassword(email, password)
            if (user != null) {
                onResult(true, "Login successful")
            } else {
                onResult(false, "Invalid email or password")
            }
        }
    }
}
