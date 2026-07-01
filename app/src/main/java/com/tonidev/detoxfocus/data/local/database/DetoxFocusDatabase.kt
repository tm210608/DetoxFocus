package com.tonidev.detoxfocus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [BlockedAppEntity::class, HabitTaskEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DetoxFocusDatabase : RoomDatabase() {
    abstract fun blockedAppDao(): BlockedAppDao
    abstract fun habitTaskDao(): HabitTaskDao
}