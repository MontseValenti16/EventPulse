package com.montse.eventpulse.features.events.domain.usecases.shared

import com.montse.eventpulse.features.events.domain.repositories.EventRepository
import javax.inject.Inject

class GetEventTasksUseCase @Inject constructor(
    private val repository: EventRepository
) {
    suspend operator fun invoke(eventId: String) = repository.getTasks(eventId)
}