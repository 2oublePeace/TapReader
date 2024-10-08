package com.emiryanvl.tapreader.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.emiryanvl.tapreader.data.local.entities.BookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {
    @Query("SELECT * FROM book")
    fun findAllBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM book WHERE id = :id")
    fun findBookById(id: Int): Flow<BookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: BookEntity)

    @Delete
    suspend fun deleteBookById(book: BookEntity)
}