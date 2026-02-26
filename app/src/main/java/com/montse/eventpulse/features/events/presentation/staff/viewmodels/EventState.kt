package com.montse.eventpulse.features.events.presentation.staff.viewmodels

import com.montse.eventpulse.features.events.domain.model.Incident
import com.montse.eventpulse.features.events.domain.model.Task

data class EventState(
    val tasks: List<Task> = emptyList(),
    val incidents: List<Incident> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isConnected: Boolean = false
)