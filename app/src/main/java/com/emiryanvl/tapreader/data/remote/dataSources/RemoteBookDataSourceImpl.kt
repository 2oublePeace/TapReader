package com.emiryanvl.tapreader.data.remote.dataSources

import com.emiryanvl.tapreader.data.remote.apiServices.GoogleBooksApiService
import com.emiryanvl.tapreader.domain.models.Book
import javax.inject.Inject

class RemoteBookDataSourceImpl @Inject constructor(
    private val googleBooksApi: GoogleBooksApiService
) : RemoteBookDataSource {
    override suspend fun getFilteredBooks(query: String): List<Book> {
        return googleBooksApi.getBooksByQuery("elizarov").body()?.items?.map {
            Book(
                title = it.volumeInfo.title.toString(),
                author = it.volumeInfo.authors.toString(),
                description = it.volumeInfo.description.toString(),
                genre = it.volumeInfo.categories.toString()
            )
        } ?: emptyList()
    }

}