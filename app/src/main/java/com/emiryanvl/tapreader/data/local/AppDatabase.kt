package com.emiryanvl.tapreader.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.emiryanvl.tapreader.data.local.dao.BookDao
import com.emiryanvl.tapreader.data.local.entities.BookEntity

@Database(entities = [BookEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}