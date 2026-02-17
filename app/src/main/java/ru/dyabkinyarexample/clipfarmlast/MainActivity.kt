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
import androidx.compose.ui.tooling.preview.Preview

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
        composable("login2") { LoginScreen2(navController) }
        composable("projects") { ProjectsScreen(navController) }
        composable("new_project") { NewProjectScreen(navController) }
        composable("settings_project") { SettingsProjectScreen(navController) }
        composable("full_projects") { FullProjectsScreen(navController) }
        composable("configuration") { ConfigurationScreen(navController) }
        composable("server_load") { ServerLoadScreen(navController) }
        composable("server_processing") { ServerProcessingScreen(navController) }
        composable("server_replacement") { ServerReplacementScreen(navController) }
        composable("card_balance") { CardBalanceScreen(navController) }



        composable("server_selection") { ServerSelectionScreen(navController) }
        composable("monitoring") { MonitoringScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
    }
}



@Preview(showBackground = true, widthDp = 414, heightDp = 896)
@Composable
private fun MainActivityPreview() {
    ClipfarlastTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ClipFactoryApp()
        }
    }
}

