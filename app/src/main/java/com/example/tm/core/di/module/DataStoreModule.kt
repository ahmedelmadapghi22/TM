package com.example.tm.core.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tm.data.local.room.DatabaseConstants
import com.example.tm.data.local.room.MainDatabase
import com.example.tm.data.local.room.doa.MaterialsDoa
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): MainDatabase {
        return Room.databaseBuilder(
            context,
            MainDatabase::class.java,
            DatabaseConstants.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideMaterialDoa(mainDatabase: MainDatabase): MaterialsDoa {
        return mainDatabase.getMaterialDoa()


    }
}