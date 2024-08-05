package com.emiryanvl.tapreader.data.repositories

import com.emiryanvl.tapreader.data.dao.BookDao
import com.emiryanvl.tapreader.data.entities.BookEntity
import com.emiryanvl.tapreader.domain.models.BookModel
import com.emiryanvl.tapreader.domain.repositories.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BookRepositoryImpl(private val dao: BookDao) : BookRepository {
    override suspend fun addBook(book: BookModel) {
        dao.insertBook(
            BookEntity(
                title = book.title,
                description = book.description,
            )
        )
    }

    override suspend fun getBook(id: Int): BookModel = dao.getBookById(id).toBookModel()

    override fun getAllBooks(): Flow<List<BookModel>> = dao.getAllBooks().map { list ->
        list.map {
            it.toBookModel()
        }
    }

    override suspend fun updateBook(id: Int, book: BookModel) {
        val oldBook = dao.getBookById(id)
        return dao.insertBook(
            oldBook.also {
                it.title = book.title
                it.description = book.description
            }
        )
    }

    override suspend fun deleteBook(id: Int) {
        val book = dao.getBookById(id)
        dao.deleteBookById(book)
    }
}