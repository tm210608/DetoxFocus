package com.tonidev.detoxfocus.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitTaskDao {
    @Query("SELECT * FROM habit_tasks WHERE isCompleted = 0 ORDER BY priority ASC")
    fun getPendingTasks(): Flow<List<HabitTaskEntity>>

    @Insert
    suspend fun insert(task: HabitTaskEntity)

    @Query("UPDATE habit_tasks SET isCompleted = 1 WHERE id = :id")
    suspend fun markCompleted(id: Long)
}