package ru.dyabkinyarexample.clipfarmlast.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF00D4FF),           // Accent - голубой
    secondary = Color(0xFF00D4FF),         // AccentLight - светлый голубой
    tertiary = Color(0xFF0099CC),          // AccentDark - темный голубой
    background = Color(0xFF0d0d0d),        // Background - очень темный
    surface = Color(0xFF1a1a1a),           // Surface - темный
    error = Color(0xFFFF5252),             // StatusError - красный
    onPrimary = Color.White,               // TextPrimary - белый
    onSecondary = Color(0xFF888888),       // TextSecondary - серый
    onBackground = Color.White,            // TextPrimary - белый
    onSurface = Color.White,               // TextPrimary - белый
)

@Composable
fun ClipfarlastTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
