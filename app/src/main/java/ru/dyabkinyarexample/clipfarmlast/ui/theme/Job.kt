package ru.dyabkinyarexample.clipfarmlast.model

data class Job(
    val id: String,
    val projectName: String,
    val status: String, // "Running", "Done", "Error", "Queued"
    val progress: Int,
    val eta: String,
    val cost: String
)

val sampleJobs = listOf(
    Job("job1", "Film_120min_01", "Running", 37, "06:20", "$2.15"),
    Job("job2", "Podcast_Ep5", "Done", 100, "завершено", "$1.85"),
    Job("job3", "Tutorial_4K", "Queued", 0, "ожидание", "$0.00")
)
