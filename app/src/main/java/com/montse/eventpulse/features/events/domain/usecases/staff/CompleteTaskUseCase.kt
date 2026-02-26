package com.montse.eventpulse.features.events.domain.usecases.staff

import com.montse.eventpulse.features.events.domain.repositories.EventRepository
import javax.inject.Inject

class CompleteTaskUseCase @Inject constructor(private val repository: EventRepository) {
    suspend operator fun invoke(taskId: String) {
        // repository.updateTaskStatus(taskId, "completada")
    }
}