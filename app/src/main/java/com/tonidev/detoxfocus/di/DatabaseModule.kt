package com.tonidev.detoxfocus.di

import android.content.Context
import androidx.room.Room
import com.tonidev.detoxfocus.data.local.BlockedAppDao
import com.tonidev.detoxfocus.data.local.DetoxFocusDatabase
import com.tonidev.detoxfocus.data.local.HabitTaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DetoxFocusDatabase {
        return Room.databaseBuilder(
            context,
            DetoxFocusDatabase::class.java,
            "detox_focus_db"
        ).build()
    }

    @Provides
    fun provideBlockedAppDao(database: DetoxFocusDatabase): BlockedAppDao {
        return database.blockedAppDao()
    }

    @Provides
    fun provideHabitTaskDao(database: DetoxFocusDatabase): HabitTaskDao {
        return database.habitTaskDao()
    }
}
