package com.emiryanvl.tapreader.data.repositories

import com.emiryanvl.tapreader.data.dao.BookDao
import com.emiryanvl.tapreader.data.entities.BookEntity
import com.emiryanvl.tapreader.domain.models.Book
import com.emiryanvl.tapreader.domain.repositories.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BookRepositoryImpl(private val dao: BookDao) : BookRepository {

    override fun getAllBooks(): Flow<List<Book>> = dao.getAllBooks().map { list ->
        list.map {
            it.toBookModel()
        }
    }

    override suspend fun addBook(book: Book) {
        dao.insertBook(
            BookEntity(
                title = book.title,
                description = book.description,
            )
        )
    }

    override suspend fun getBook(id: Int): Book = dao.getBookById(id).toBookModel()

    override suspend fun updateBook(id: Int, book: Book) {
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