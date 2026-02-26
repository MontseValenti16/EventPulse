package com.montse.eventpulse.features.events.data.repositories

import com.montse.eventpulse.features.events.data.local.TaskEntity
import com.montse.eventpulse.features.events.data.remote.model.TaskDto
import com.montse.eventpulse.features.events.domain.model.Task

fun TaskEntity.toDomain(): Task = Task(
    id = id, eventId = eventId, zoneId = zoneId, zoneName = zoneName,
    title = title, description = description, status = status,
    priority = priority, createdBy = createdBy, assignedTo = assignedTo,
    assignedName = assignedName, completedAt = completedAt, createdAt = createdAt
)

fun TaskDto.toEntity(): TaskEntity = TaskEntity(
    id = id, eventId = eventId, zoneId = zoneId, zoneName = zoneName,
    title = title, description = description, status = status,
    priority = priority, createdBy = createdBy, assignedTo = assignedTo,
    assignedName = assignedName, completedAt = completedAt, createdAt = createdAt
)