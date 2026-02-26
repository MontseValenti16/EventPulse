package com.montse.eventpulse.features.events.data.repositories

import com.montse.eventpulse.features.events.data.local.EventDao
import com.montse.eventpulse.features.events.data.remote.EventApiService
import com.montse.eventpulse.features.events.data.remote.EventSocketService
import com.montse.eventpulse.features.events.domain.model.Task
import com.montse.eventpulse.features.events.domain.repositories.EventRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val apiService: EventApiService,
    private val socketService: EventSocketService,
    private val eventDao: EventDao
) : EventRepository {

    override suspend fun getTasks(eventId: String): Flow<List<Task>> {
        return eventDao.getTasksForEvent(eventId)
            .map { entities ->
                entities.map { it.toDomain() }
            }
            .onStart {
                // Ejecutamos la carga de red en paralelo al iniciar el flujo
                try {
                    val remoteTasks = apiService.getTasksByEvent(eventId)
                    eventDao.insertTasks(remoteTasks.map { it.toEntity() })
                } catch (e: Exception) {
                    // Si falla la red, ya estamos emitiendo lo local
                }
            }
    }

    override fun observeRealTimeTasks(eventId: String): Flow<Task> {
        return socketService.observeEventUpdates(eventId)
    }

    override suspend fun reportIncident(eventId: String, title: String, description: String) {
        // Implementación pendiente
    }

    override suspend fun updateTaskStatus(taskId: String, newStatus: String) {
        try {
            // Actualizamos en local para respuesta inmediata
            eventDao.updateTaskStatus(taskId, newStatus)
            // Aquí llamarías a la API si fuera necesario
        } catch (e: Exception) {
            // Manejar error
        }
    }
}