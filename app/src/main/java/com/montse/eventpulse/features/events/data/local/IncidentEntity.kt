package com.montse.eventpulse.features.events.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "incidents")
data class IncidentEntity(
    @PrimaryKey val id: String,
    val eventId: String, // evento_id
    val zoneId: String,  // zona_id
    val zoneName: String, // zona_nombre
    val type: String,    // tipo (medico, seguridad, etc)
    val description: String,
    val status: String,  // estado (pendiente, resuelta)
    val createdBy: String, // creada_por
    val assignedTo: String?, // asignada_a (puede ser nulo si nadie la ha tomado)
    val assignedName: String?, // nombre_asignado
    val createdAt: String,
    val updatedAt: String?
)