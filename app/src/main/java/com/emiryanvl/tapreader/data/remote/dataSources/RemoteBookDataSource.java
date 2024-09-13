package com.emiryanvl.tapreader.data.remote.dataSources;

import com.emiryanvl.tapreader.domain.model.Book;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface RemoteBookDataSource {

    Observable<List<Book>> getBooksByQuery(String query);

    Observable<List<Book>> getBooksBySubject(String subject);
}
