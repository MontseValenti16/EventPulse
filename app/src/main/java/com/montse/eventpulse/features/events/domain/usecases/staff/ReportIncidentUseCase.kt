package com.montse.eventpulse.features.events.domain.usecases.staff

import com.montse.eventpulse.features.events.domain.repositories.EventRepository
import javax.inject.Inject

class ReportIncidentUseCase @Inject constructor(private val repository: EventRepository) {
    suspend operator fun invoke(eventId: String, title: String, description: String) {
        repository.reportIncident(eventId, title, description)
    }
}