package com.emiryanvl.tapreader.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.emiryanvl.tapreader.domain.models.Book

@Entity(tableName = "book")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val genre: String?,
    val author: String
) {

    companion object {
        fun toBookModel(bookEntity: BookEntity) = Book(
            id = bookEntity.id,
            title = bookEntity.title,
            description = bookEntity.description,
            genre = bookEntity.genre,
            author = bookEntity.author
        )

        fun toBookEntity(book: Book) = BookEntity(
            id = book.id,
            title = book.title,
            description = book.description,
            author = book.author,
            genre = book.genre
        )
    }
}