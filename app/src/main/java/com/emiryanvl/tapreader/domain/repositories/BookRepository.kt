package com.emiryanvl.tapreader.domain.repositories

import com.emiryanvl.tapreader.domain.models.BookModel
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getAllBooks(): Flow<List<BookModel>>

    suspend fun addBook(book: BookModel)

    suspend fun getBook(id: Int): BookModel

    suspend fun updateBook(id: Int, book: BookModel)

    suspend fun deleteBook(id: Int)
}