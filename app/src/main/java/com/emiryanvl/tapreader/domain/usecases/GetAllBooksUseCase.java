package com.emiryanvl.tapreader.domain.usecases;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import java.util.List;

import javax.inject.Inject;

public class GetAllBooksUseCase {

    BookRepository repository;

    @Inject
    public GetAllBooksUseCase(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> invoke() {
        return repository.getAllBooks();
    }
}
