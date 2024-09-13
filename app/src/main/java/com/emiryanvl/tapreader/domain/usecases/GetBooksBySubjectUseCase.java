package com.emiryanvl.tapreader.domain.usecases;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class GetBooksBySubjectUseCase {

    private final BookRepository repository;

    @Inject

    public GetBooksBySubjectUseCase(BookRepository repository) {
        this.repository = repository;
    }

    public Observable<List<Book>> execute(String subject) {
        return repository.getBooksBySubject(subject);
    }
}
