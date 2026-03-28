package ru.dyabkinyarexample.clipfarmlast.ui.screens

import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import org.json.JSONObject
import org.osmdroid.api.IMapController
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import java.util.Locale

private data class PlacePoint(
    val name: String,
    val description: String,
    val latitude: Double,
    val longitude: Double
)

private data class WeatherInfo(
    val city: String,
    val temperature: String,
    val windSpeed: String,
    val observedAt: String
)

private sealed interface WeatherUiState {
    data object Loading : WeatherUiState
    data class Success(val info: WeatherInfo) : WeatherUiState
    data class Error(val message: String) : WeatherUiState
}

private val places = listOf(
    PlacePoint(
        name = "EU-West (Amsterdam)",
        description = "Нидерланды, регион EU-West. Цена: $0.42/мин; Скорость: ~1k; Пинг: ~35ms",
        latitude = 52.3676,
        longitude = 4.9041
    ),
    PlacePoint(
        name = "EU-Central (Frankfurt)",
        description = "Германия, регион EU-Central. Цена: $0.39/мин; Скорость: ~1.0k; Пинг: ~45ms",
        latitude = 50.1109,
        longitude = 8.6821
    ),
    PlacePoint(
        name = "ES-East (Virginia)",
        description = "США, East US / Virginia. Цена: $0.33/мин; Скорость: ~1.2k; Пинг: ~90ms",
        latitude = 39.0438,
        longitude = -77.4874
    ),
    PlacePoint(
        name = "ES-West (Singapore)",
        description = "Сингапур, Asia-Pacific. Цена: $0.45/мин; Скорость: ~1.0k; Пинг: ~180ms",
        latitude = 1.3521,
        longitude = 103.8198
    ),
    PlacePoint(
        name = "Asia-Tokyo",
        description = "Япония, регион Asia-Tokyo. Цена: $0.52/мин; Скорость: ~1.35k; Пинг: ~220ms",
        latitude = 35.6762,
        longitude = 139.6503
    )
)

@Composable
fun ServerSelectionScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val weatherState by produceState<WeatherUiState>(initialValue = WeatherUiState.Loading) {
        value = try {
            val place = places.first()
            WeatherUiState.Success(fetchWeather(place))
        } catch (e: Exception) {
            WeatherUiState.Error("Не удалось загрузить данные API")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0d0d0d))
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Карта серверов и API", fontSize = 28.sp, color = Color.White, style = MaterialTheme.typography.headlineMedium)
        Text(
            text = "На карте показаны регионы серверов с описанием, ниже отображаются данные из открытого API Open-Meteo.",
            color = Color(0xFFB0B0B0),
            fontSize = 14.sp
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp),
            color = Color(0xFF1a1a1a),
            shape = MaterialTheme.shapes.medium
        ) {
            AndroidView(
                factory = { context ->
                    MapView(context).apply {
                        setTileSource(TileSourceFactory.MAPNIK)
                        setMultiTouchControls(true)
                        controller.setZoom(4.5)
                        controller.setCenter(GeoPoint(places.first().latitude, places.first().longitude))
                    }
                },
                modifier = Modifier.fillMaxSize(),
                update = { mapView ->
                    val controller: IMapController = mapView.controller
                    controller.setCenter(GeoPoint(places.first().latitude, places.first().longitude))
                    controller.setZoom(4.5)

                    mapView.overlays.clear()
                    places.forEach { place ->
                        val marker = Marker(mapView).apply {
                            position = GeoPoint(place.latitude, place.longitude)
                            title = place.name
                            snippet = place.description
                            setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                        }
                        mapView.overlays.add(marker)
                    }
                    mapView.invalidate()
                }
            )
        }

        Text("Данные Open-Meteo", color = Color.White, fontSize = 20.sp, style = MaterialTheme.typography.titleLarge)

        when (val state = weatherState) {
            WeatherUiState.Loading -> {
                CircularProgressIndicator(color = Color(0xFF00D4FF))
            }
            is WeatherUiState.Success -> {
                InfoCard(
                    title = state.info.city,
                    lines = listOf(
                        "Температура: ${state.info.temperature} °C",
                        "Ветер: ${state.info.windSpeed} м/с",
                        "Время наблюдения: ${state.info.observedAt}"
                    )
                )
            }
            is WeatherUiState.Error -> {
                Text(state.message, color = Color(0xFFFF6B6B))
            }
        }

        HorizontalDivider(color = Color(0xFF2A2A2A))

        Text("Метки на карте", color = Color.White, fontSize = 20.sp, style = MaterialTheme.typography.titleLarge)
        places.forEach { place ->
            InfoCard(
                title = place.name,
                lines = listOf(
                    place.description,
                    "Координаты: ${place.latitude.format()} , ${place.longitude.format()}"
                )
            )
        }
    }
}

@Composable
private fun InfoCard(title: String, lines: List<String>) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFF1a1a1a),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(title, color = Color.White, fontSize = 16.sp, style = MaterialTheme.typography.titleMedium)
            lines.forEach { line ->
                Text(line, color = Color(0xFFB0B0B0), fontSize = 13.sp)
            }
        }
    }
}

private suspend fun fetchWeather(place: PlacePoint): WeatherInfo = withContext(Dispatchers.IO) {
    val apiUrl =
        "https://api.open-meteo.com/v1/forecast?latitude=${place.latitude}&longitude=${place.longitude}&current=temperature_2m,wind_speed_10m&timezone=auto"
    val json = JSONObject(URL(apiUrl).readText())
    val current = json.getJSONObject("current")

    WeatherInfo(
        city = place.name,
        temperature = String.format(Locale.US, "%.1f", current.getDouble("temperature_2m")),
        windSpeed = String.format(Locale.US, "%.1f", current.getDouble("wind_speed_10m")),
        observedAt = current.getString("time")
    )
}

private fun Double.format(): String = String.format(Locale.US, "%.4f", this)
