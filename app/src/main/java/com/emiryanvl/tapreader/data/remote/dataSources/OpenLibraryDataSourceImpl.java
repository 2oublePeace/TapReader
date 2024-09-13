package com.emiryanvl.tapreader.data.remote.dataSources;

import com.emiryanvl.tapreader.data.remote.apiServices.OpenLibraryApiService;
import com.emiryanvl.tapreader.data.remote.responses.OpenLibrarySubjectApiResponse;
import com.emiryanvl.tapreader.domain.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class OpenLibraryDataSourceImpl implements RemoteBookDataSource {

    private final OpenLibraryApiService apiService;

    @Inject
    public OpenLibraryDataSourceImpl(OpenLibraryApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<List<Book>> getBooksByQuery(String query) {
        return Observable.create(emitter -> emitter.onNext(
            apiService.getBooksByQuery(query).execute().body().getDocs()
                .stream()
                .map(doc -> new Book(
                    doc.getTitle(),
                    "daasdsad", //todo() сделать получение автора
                    "asdasd", //todo() сделать получение описания
                    "sdasd" //todo() сделать получение жанра
                ))
                .collect(Collectors.toList())
        ));
    }

    @Override
    public Observable<List<Book>> getBooksBySubject(String subject) {
        return Observable.create(emitter -> emitter.onNext(
            apiService.getBooksBySubject(subject).execute().body().getWorks()
                .stream()
                .map(work -> new Book(
                    work.getTitle(),
                    work.getAuthors().stream()
                        .map(author -> author.getName())
                        .collect(Collectors.joining(",")),
                    "sdfsdf", //todo() сделать получение описания
                    "sdfsdf" //todo() сделать получение жанра
                ))
                .collect(Collectors.toList())
        ));
    }
}
