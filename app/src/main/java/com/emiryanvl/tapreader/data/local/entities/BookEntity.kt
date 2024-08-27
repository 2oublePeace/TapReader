package com.emiryanvl.tapreader.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.emiryanvl.tapreader.domain.models.Book

@Entity(tableName = "book")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val author: String,
    val description: String,
    val genre: String? = null,
    val isbn: String? = null
) {

    companion object {
        fun toBookModel(bookEntity: BookEntity) = Book(
            id = bookEntity.id,
            title = bookEntity.title,
            description = bookEntity.description,
            genre = bookEntity.genre,
            author = bookEntity.author,
            isbn = bookEntity.isbn
        )

        fun toBookEntity(book: Book) = BookEntity(
            id = book.id,
            title = book.title,
            description = book.description,
            author = book.author,
            genre = book.genre,
            isbn = book.isbn
        )
    }
}