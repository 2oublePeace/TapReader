package com.emiryanvl.tapreader.domain.repositories

import com.emiryanvl.tapreader.domain.models.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    fun getAllBooks(): Flow<List<Book>>

    fun getBooksByQuery(query: String): Flow<List<Book>>

    fun getBooksBySubject(subject: String): Flow<List<Book>>

    fun getBook(id: Int): Flow<Book>

    suspend fun addBook(book: Book)

    suspend fun updateBook(id: Int, book: Book)

    suspend fun deleteBook(id: Int)
}