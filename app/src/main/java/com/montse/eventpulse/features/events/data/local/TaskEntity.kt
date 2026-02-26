package com.montse.eventpulse.features.events.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey val id: String,
    val eventId: String,
    val zoneId: String,
    val zoneName: String,
    val title: String,
    val description: String,
    val status: String,    // pendiente, en_progreso, completada
    val priority: String,  // alta, media, baja
    val createdBy: String,
    val assignedTo: String?,
    val assignedName: String?,
    val completedAt: String?,
    val createdAt: String
)