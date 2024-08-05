package com.emiryanvl.tapreader.domain.usecases

import com.emiryanvl.tapreader.domain.models.BookModel
import com.emiryanvl.tapreader.domain.repositories.BookRepository
import javax.inject.Inject

class AddBookUseCase @Inject constructor(private val repository: BookRepository) {
    suspend operator fun invoke(book: BookModel) = repository.addBook(book)
}