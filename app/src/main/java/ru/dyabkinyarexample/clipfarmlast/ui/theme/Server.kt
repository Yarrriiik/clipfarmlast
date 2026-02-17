package ru.dyabkinyarexample.clipfarmlast.model

data class Server(
    val id: String,
    val region: String,
    val price: String,
    val speed: String,
    val queue: String,
    val ping: String,
    val isRecommended: Boolean = false
)

val sampleServers = listOf(
    Server("eu1", "EU-West (Amsterdam)", "$0.42/мин", "~1.1×", "низкая (2-4 мин)", "25-40 ms", true),
    Server("eu2", "EU-Central (Frankfurt)", "$0.39/мин", "~1.0×", "средняя (5-10 мин)", "35-55 ms"),
    Server("us1", "US-East (Virginia)", "$0.33/мин", "~1.2×", "высокая (12-25 мин)", "90-130 ms"),
    Server("us2", "US-West (Oregon)", "$0.36/мин", "~1.15×", "средняя (6-12 мин)", "140-170 ms"),
    Server("asia1", "Asia-SG (Singapore)", "$0.45/мин", "~1.0×", "низкая (3-6 мин)", "180-230 ms"),
    Server("asia2", "Asia-Tokyo", "$0.52/мин", "~1.35×", "низкая (1-3 мин)", "220-260 ms")
)
