package com.emiryanvl.tapreader.data.remote.dataSources

import com.emiryanvl.tapreader.data.remote.apiServices.GoogleBooksApiService
import com.emiryanvl.tapreader.domain.models.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteBookDataSourceImpl @Inject constructor(
    private val googleBooksApi: GoogleBooksApiService
) : RemoteBookDataSource {

    override fun getQueryBooks(query: String): Flow<List<Book>> = flow {
        emit(
            googleBooksApi.getBooksByQuery(query).body()?.items?.map { book ->
                Book(
                    title = book.volumeInfo.title.toString(),
                    author = book.volumeInfo.authors.toString(),
                    description = book.volumeInfo.description.toString(),
                    genre = book.volumeInfo.categories?.joinToString(separator = ","),
                    //TODO будет доделано в рамках другой задачи
                    isbn = book.volumeInfo.industryIdentifiers.firstOrNull()?.identifier ?: ""
                )
            } ?: emptyList()
        )
    }
}