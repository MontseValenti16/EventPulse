package com.montse.eventpulse.features.events.domain.usecases.admin

import com.montse.eventpulse.features.events.domain.repositories.EventRepository
import javax.inject.Inject

class AssignIncidentUseCase @Inject constructor(private val repository: EventRepository) {
    suspend operator fun invoke(incidentId: String, staffId: String) {
        // Implementar lógica de asignación
    }
}