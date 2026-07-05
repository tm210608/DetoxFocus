package com.tonidev.detoxfocus.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [BlockedAppEntity::class, HabitTaskEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DetoxFocusDatabase : RoomDatabase() {
    abstract fun blockedAppDao(): BlockedAppDao
    abstract fun habitTaskDao(): HabitTaskDao

    companion object {
        @Volatile
        private var INSTANCE: DetoxFocusDatabase? = null

        fun getInstance(context: Context): DetoxFocusDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DetoxFocusDatabase::class.java,
                    "detox_focus_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}