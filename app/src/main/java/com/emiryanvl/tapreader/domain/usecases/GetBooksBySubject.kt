package com.emiryanvl.tapreader.domain.usecases

import com.emiryanvl.tapreader.domain.repositories.BookRepository
import javax.inject.Inject

class GetBooksBySubject @Inject constructor(private val repository: BookRepository) {
    operator fun invoke(subject: String) = repository.getBooksBySubject(subject)
}