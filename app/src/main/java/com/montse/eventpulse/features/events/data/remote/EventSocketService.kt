package com.montse.eventpulse.features.events.data.remote

import com.montse.eventpulse.features.events.domain.model.Task
import io.ktor.client.*
import io.ktor.client.plugins.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.flow.*
import kotlinx.serialization.json.Json

class EventSocketService(private val client: HttpClient) {
    fun observeEventUpdates(eventId: String): Flow<Task> = flow {
        client.webSocketSession(host = "10.0.2.2", port = 8080, path = "/ws/events/$eventId").use { session ->
            session.incoming.receiveAsFlow()
                .filterIsInstance<Frame.Text>()
                .collect { frame ->
                    val task = Json.decodeFromString<Task>(frame.readText())
                    emit(task)
                }
        }
    }
}