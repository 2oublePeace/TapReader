package com.emiryanvl.tapreader.data.remote.dataSources

import com.emiryanvl.tapreader.data.remote.apiServices.GoogleBooksApiService
import com.emiryanvl.tapreader.domain.models.Book
import javax.inject.Inject

class RemoteBookDataSourceImpl @Inject constructor(
    private val googleBooksApi: GoogleBooksApiService
) : RemoteBookDataSource {
    override suspend fun getFilteredBooks(query: String): List<Book> {
        return googleBooksApi.getBooksByQuery(query).body()?.items?.map { book ->
            Book(
                title = book.volumeInfo.title.toString(),
                author = book.volumeInfo.authors.toString(),
                description = book.volumeInfo.description.toString(),
                genre = book.volumeInfo.categories?.joinToString(separator = ",")
            )
        } ?: emptyList()
    }

}