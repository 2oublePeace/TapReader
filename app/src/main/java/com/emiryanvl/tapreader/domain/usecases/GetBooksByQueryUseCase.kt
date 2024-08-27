package com.emiryanvl.tapreader.domain.usecases

import com.emiryanvl.tapreader.domain.repositories.BookRepository
import javax.inject.Inject

class GetBooksByQueryUseCase @Inject constructor(private val repository: BookRepository) {
    operator fun invoke(query: String) = repository.getBooksByQuery(query)
}
