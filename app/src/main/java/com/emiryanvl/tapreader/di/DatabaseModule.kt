package com.emiryanvl.tapreader.di

import android.content.Context
import androidx.room.Room
import com.emiryanvl.tapreader.data.local.AppDatabase
import com.emiryanvl.tapreader.data.local.dao.BookDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
class DatabaseModule {

    @[Provides Singleton]
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @[Provides Singleton]
    fun provideBookDao(appDatabase: AppDatabase): BookDao = appDatabase.bookDao()

    companion object {
        private const val DATABASE_NAME = "tap_reader_database"
    }
}