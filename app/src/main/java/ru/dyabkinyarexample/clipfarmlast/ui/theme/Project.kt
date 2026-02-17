package ru.dyabkinyarexample.clipfarmlast.model

data class Project(
    val id: String,
    val name: String,
    val status: String, // "Queued", "Running", "Ready", "Error"
    val clipsCount: Int,
    val duration: String,
    val createdAt: String,
    val preset: String
)

// Фиксированные данные для примера
val sampleProjects = listOf(
    Project("1", "Film_120min_01", "Ready", 12, "2h 15m", "5 мин назад", "NeonSub"),
    Project("2", "Podcast_Ep5", "Running", 8, "1h 30m", "1 час назад", "Minimal"),
    Project("3", "Tutorial_4K", "Queued", 0, "45m", "2 часа назад", "Bold")
)
