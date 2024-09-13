package com.emiryanvl.tapreader.di;

import com.emiryanvl.tapreader.data.BookRepositoryImpl;
import com.emiryanvl.tapreader.data.local.dataSources.DatabaseDataSourceImpl;
import com.emiryanvl.tapreader.data.local.dataSources.LocalBookDataSource;
import com.emiryanvl.tapreader.data.remote.dataSources.OpenLibraryDataSourceImpl;
import com.emiryanvl.tapreader.data.remote.dataSources.RemoteBookDataSource;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import dagger.Binds;
import dagger.Module;

@Module
public interface BindModule {

    @Binds
    RemoteBookDataSource bindRemoteBookDataSourceImplToRemoteBookDataSource(
        OpenLibraryDataSourceImpl dataSource
    );

    @Binds
    BookRepository bindBookRepositoryImplToBookRepository(
        BookRepositoryImpl repository
    );

    @Binds
    LocalBookDataSource bindLocalBookDataSourceImplToLocalBookDataSource(
        DatabaseDataSourceImpl dataSource
    );
}
