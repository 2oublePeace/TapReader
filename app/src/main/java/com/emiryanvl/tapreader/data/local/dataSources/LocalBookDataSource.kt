package com.emiryanvl.tapreader.data.local.dataSources

import com.emiryanvl.tapreader.domain.models.Book
import kotlinx.coroutines.flow.Flow

interface LocalBookDataSource {

    fun getAllBooks(): Flow<List<Book>>

    suspend fun getBook(id: Int): Book

    suspend fun addBook(book: Book)

    suspend fun updateBook(id: Int, book: Book)

    suspend fun deleteBook(id: Int)
}