package com.emiryanvl.tapreader.di

import com.emiryanvl.tapreader.data.BookRepositoryImpl
import com.emiryanvl.tapreader.data.local.dataSources.LocalBookDataSource
import com.emiryanvl.tapreader.data.local.dataSources.LocalBookDataSourceImpl
import com.emiryanvl.tapreader.data.remote.dataSources.RemoteBookDataSource
import com.emiryanvl.tapreader.data.remote.dataSources.RemoteBookDataSourceImpl
import com.emiryanvl.tapreader.domain.repositories.BookRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BindModule {

    @Binds
    fun bindBookRepositoryImplToBookRepository(
        bookRepositoryImpl: BookRepositoryImpl
    ): BookRepository

    @Binds
    fun bindLocalDataSourceImplToLocalDataSource(
        localBookDataSourceImpl: LocalBookDataSourceImpl
    ): LocalBookDataSource

    @Binds
    fun bindRemoteDataSourceImplToRemoteDataSource(
        remoteBookDataSourceImpl: RemoteBookDataSourceImpl
    ): RemoteBookDataSource
}