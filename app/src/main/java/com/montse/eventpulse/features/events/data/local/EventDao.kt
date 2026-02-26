package com.montse.eventpulse.features.events.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Query("SELECT * FROM TaskEntity WHERE eventId = :eventId")
    fun getTasksForEvent(eventId: String): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTasks(tasks: List<TaskEntity>)

    @Query("UPDATE TaskEntity SET status = :status WHERE id = :taskId")
    suspend fun updateTaskStatus(taskId: String, status: String)
}