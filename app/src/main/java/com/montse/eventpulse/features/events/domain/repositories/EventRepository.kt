package com.montse.eventpulse.features.events.domain.repositories

import com.montse.eventpulse.features.events.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface EventRepository {
    suspend fun getTasks(eventId: String): Flow<List<Task>>
    fun observeRealTimeTasks(eventId: String): Flow<Task>
}