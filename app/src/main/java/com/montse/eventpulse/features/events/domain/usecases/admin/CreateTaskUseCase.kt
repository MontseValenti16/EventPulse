package com.montse.eventpulse.features.events.domain.usecases.admin

import com.montse.eventpulse.features.events.domain.repositories.EventRepository
import javax.inject.Inject

class CreateTaskUseCase @Inject constructor(private val repository: EventRepository) {
    suspend operator fun invoke(eventId: String, title: String, description: String) {
        // Implementar creación de tarea
    }
}