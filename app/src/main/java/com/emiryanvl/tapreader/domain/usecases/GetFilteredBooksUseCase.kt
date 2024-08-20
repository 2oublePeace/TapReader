package com.emiryanvl.tapreader.domain.usecases

import com.emiryanvl.tapreader.domain.repositories.BookRepository
import javax.inject.Inject

class GetFilteredBooksUseCase @Inject constructor(private val repository: BookRepository) {
    suspend operator fun invoke(filter: String) = repository.getFilteredBooks(filter)
}
