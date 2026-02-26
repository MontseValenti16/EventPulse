package com.montse.eventpulse.features.events.data.remote

import com.montse.eventpulse.features.events.data.remote.model.TaskDto
import retrofit2.http.GET
import retrofit2.http.Path

interface EventApiService {
    @GET("events/{id}/tasks")
    suspend fun getTasksByEvent(@Path("id") eventId: String): List<TaskDto>
}