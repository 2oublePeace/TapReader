package com.emiryanvl.tapreader.domain.usecases

import com.emiryanvl.tapreader.domain.repositories.BookRepository
import javax.inject.Inject

class DeleteBookUseCase @Inject constructor(private val repository: BookRepository) {
    suspend operator fun invoke(id: Int) = repository.deleteBook(id)
}