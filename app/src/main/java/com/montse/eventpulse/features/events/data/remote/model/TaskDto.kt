package com.montse.eventpulse.features.events.data.remote.model

import com.google.gson.annotations.SerializedName

data class TaskDto(
    val id: String,

    // Usamos @SerializedName para mapear el JSON (snake_case) a Kotlin (camelCase)
    @SerializedName("evento_id") val eventId: String,
    @SerializedName("zona_id") val zoneId: String,
    @SerializedName("zona_nombre") val zoneName: String,
    @SerializedName("titulo") val title: String,
    @SerializedName("descripcion") val description: String,
    @SerializedName("estado") val status: String,      // pendiente, en_progreso, completada
    @SerializedName("prioridad") val priority: String, // alta, media, baja
    @SerializedName("creada_por") val createdBy: String,
    @SerializedName("asignada_a") val assignedTo: String?, // Puede ser nulo
    @SerializedName("nombre_asignado") val assignedName: String?,
    @SerializedName("completada_en") val completedAt: String?,
    @SerializedName("creada_en") val createdAt: String
)