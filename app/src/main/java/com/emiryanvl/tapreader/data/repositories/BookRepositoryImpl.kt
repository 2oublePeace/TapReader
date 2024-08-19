package com.emiryanvl.tapreader.data.repositories

import com.emiryanvl.tapreader.data.dao.BookDao
import com.emiryanvl.tapreader.data.entities.BookEntity
import com.emiryanvl.tapreader.domain.models.Book
import com.emiryanvl.tapreader.domain.repositories.BookRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val dao: BookDao) : BookRepository {

    override fun getAllBooks() = dao.findAllBooks().map { it.map(BookEntity::toBookModel) }

    override suspend fun getBook(id: Int) = BookEntity.toBookModel(dao.findBookById(id))

    override suspend fun addBook(book: Book) = dao.insertBook(BookEntity.toBookEntity(book))

    override suspend fun updateBook(id: Int, book: Book) = dao.insertBook(
        book = dao.findBookById(id).copy(
            title = book.title,
            author = book.author,
            description = book.description,
            genre = book.genre
        )
    )

    override suspend fun deleteBook(id: Int) = dao.deleteBookById(
        book = dao.findBookById(id)
    )
}