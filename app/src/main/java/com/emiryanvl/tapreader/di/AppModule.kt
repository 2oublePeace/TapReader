package com.emiryanvl.tapreader.di

import android.content.Context
import androidx.room.Room
import com.emiryanvl.tapreader.data.AppDatabase
import com.emiryanvl.tapreader.data.dao.BookDao
import com.emiryanvl.tapreader.data.repositories.BookRepositoryImpl
import com.emiryanvl.tapreader.domain.repositories.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "tap_reader_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideBookDao(appDatabase: AppDatabase): BookDao = appDatabase.bookDao()

    @Provides
    fun provideBookRepository(bookDao: BookDao): BookRepository = BookRepositoryImpl(bookDao)
}