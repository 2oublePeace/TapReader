package com.emiryanvl.tapreader.domain.usecases;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class GetAllBooksUseCase {

    BookRepository repository;

    @Inject
    public GetAllBooksUseCase(BookRepository repository) {
        this.repository = repository;
    }

    public Observable<List<Book>> execute() {
        return repository.getAllBooks();
    }
}
