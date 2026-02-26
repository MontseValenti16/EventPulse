package com.montse.eventpulse.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.montse.eventpulse.features.auth.data.local.UserEntity
import com.montse.eventpulse.features.events.data.local.IncidentEntity
import com.montse.eventpulse.features.events.data.local.TaskEntity

@Database(
    entities = [
        UserEntity::class,      // Tabla de Usuarios (Auth)
        IncidentEntity::class,  // Tabla de Incidencias (Events)
        TaskEntity::class       // Tabla de Tareas (Events)
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {


}