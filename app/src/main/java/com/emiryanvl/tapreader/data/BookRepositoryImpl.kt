package com.emiryanvl.tapreader.data

import com.emiryanvl.tapreader.data.local.dataSources.LocalBookDataSource
import com.emiryanvl.tapreader.data.remote.dataSources.RemoteBookDataSource
import com.emiryanvl.tapreader.domain.models.Book
import com.emiryanvl.tapreader.domain.repositories.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val localBookDataSource: LocalBookDataSource
) : BookRepository {

    override fun getAllBooks() = localBookDataSource.getAllBooks()

    override fun getQueryBooks(query: String) = remoteBookDataSource.getQueryBooks(query)

    override suspend fun addBook(book: Book) = localBookDataSource.addBook(book)

    override suspend fun getBook(id: Int): Book = localBookDataSource.getBook(id)

    override suspend fun updateBook(id: Int, book: Book) = localBookDataSource.updateBook(id, book)

    override suspend fun deleteBook(id: Int) = localBookDataSource.deleteBook(id)
}