package ru.dyabkinyarexample.clipfarmlast

import android.app.Application
import androidx.room.Room
import ru.dyabkinyarexample.clipfarmlast.data.AppDatabase
import org.osmdroid.config.Configuration

class ClipFarmApplication : Application() {
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        Configuration.getInstance().userAgentValue = packageName
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "clipfarm_database"
        ).build()
    }
}
