package com.montse.eventpulse.features.events.domain.model

data class Incident(
    val id: String,
    val eventId: String,
    val zoneId: String,
    val zoneName: String,
    val type: String,        // derrame, seguridad, medico, etc.
    val description: String,
    val status: String,      // pendiente, en_atencion, resuelta
    val createdBy: String,
    val assignedTo: String?, // Puede ser nulo si nadie la ha tomado aún
    val assignedName: String?,
    val createdAt: String,
    val updatedAt: String?
)