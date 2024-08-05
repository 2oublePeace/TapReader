package com.emiryanvl.tapreader.domain.repositories

import com.emiryanvl.tapreader.domain.models.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getAllBooks(): Flow<List<Book>>

    suspend fun addBook(book: Book)

    suspend fun getBook(id: Int): Book

    suspend fun updateBook(id: Int, book: Book)

    suspend fun deleteBook(id: Int)
}