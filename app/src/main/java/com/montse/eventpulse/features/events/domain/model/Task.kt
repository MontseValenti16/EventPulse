package com.montse.eventpulse.features.events.domain.model

data class Task(
    val id: String,
    val eventId: String,
    val zoneId: String,
    val zoneName: String,
    val title: String,
    val description: String,
    val status: String,      // pendiente, en_progreso, completada
    val priority: String,    // alta, media, baja
    val createdBy: String,
    val assignedTo: String?, // Puede ser nulo
    val assignedName: String?,
    val completedAt: String?,
    val createdAt: String
)