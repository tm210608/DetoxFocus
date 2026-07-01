package com.tonidev.detoxfocus.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit_tasks")
data class HabitTaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val priority: String, // "ALTA" | "MEDIA" | "BAJA"
    val isCompleted: Boolean = false
)