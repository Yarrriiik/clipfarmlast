package ru.dyabkinyarexample.clipfarmlast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import ru.dyabkinyarexample.clipfarmlast.ui.screens.*
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.dyabkinyarexample.clipfarmlast.ui.screens.*
import ru.dyabkinyarexample.clipfarmlast.ui.theme.ClipfarlastTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClipfarlastTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ClipFactoryApp()
                }
            }
        }
    }
}

@Composable
fun ClipFactoryApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("projects") { ProjectsScreen(navController) }
        composable("new_project") { NewProjectScreen(navController) }
        composable("server_selection") { ServerSelectionScreen(navController) }
        composable("monitoring") { MonitoringScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
    }
}
