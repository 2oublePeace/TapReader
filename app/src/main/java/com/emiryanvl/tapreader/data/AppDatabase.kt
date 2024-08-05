package com.emiryanvl.tapreader.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emiryanvl.tapreader.data.dao.BookDao
import com.emiryanvl.tapreader.data.entities.BookEntity

@Database(entities = [BookEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}