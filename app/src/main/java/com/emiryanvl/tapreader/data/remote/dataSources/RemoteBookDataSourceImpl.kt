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
            googleBooksApi.getBooksByQuery(query).body()?.items?.map {
                Book(
                    title = it.volumeInfo.title.toString(),
                    author = it.volumeInfo.authors?.joinToString(separator = ",") ?: "",
                    description = it.volumeInfo.description.toString(),
                    genre = it.volumeInfo.categories?.joinToString(separator = ","),
                    isbn = it.volumeInfo.industryIdentifiers.first().identifier,
                    imageUri = it.volumeInfo.imageLinks?.thumbnail?.replace(
                        "http://",
                        "https://"
                    )
                )
            } ?: emptyList()
        )
    }
}