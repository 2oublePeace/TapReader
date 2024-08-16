package com.emiryanvl.tapreader.domain.usecases;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import javax.inject.Inject;

public class GetBookUseCase {

    BookRepository repository;

    @Inject
    public GetBookUseCase(BookRepository repository) {
        this.repository = repository;
    }

    public Book invoke(int id) {
        return repository.getBook(id);
    }
}
