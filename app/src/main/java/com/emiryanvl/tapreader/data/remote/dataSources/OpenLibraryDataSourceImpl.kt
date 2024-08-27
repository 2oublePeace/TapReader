package com.emiryanvl.tapreader.data.remote.dataSources

import com.emiryanvl.tapreader.core.Constants
import com.emiryanvl.tapreader.data.remote.apiServices.OpenLibraryApiService
import com.emiryanvl.tapreader.domain.models.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OpenLibraryDataSourceImpl @Inject constructor(
    private val openLibraryApiService: OpenLibraryApiService
) : RemoteBookDataSource {
    override fun getBooksByQuery(query: String) = flow {
        emit(
            openLibraryApiService.getBooksByQuery(query).body()?.works?.map {
                Book(
                    title = it.title,
                    author = it.authors.map { it.name }
                        .joinToString(separator = Constants.COMMA_SEPARATOR),
                    description = "Description",
                    genre = "Genre",
                    imageUri = "https://covers.openlibrary.org/b/id/${it.coverId}-M.jpg"
                )
            } ?: emptyList()
        )
    }

    override fun getBooksBySubject(subject: String) = flow {
        emit(
            openLibraryApiService.getBooksBySubject(subject).body()?.works?.map {
                Book(
                    title = it.title,
                    author = it.authors.map { it.name }.joinToString(separator = ","),
                    description = "Description",
                    genre = "Genre",
                    imageUri = "https://covers.openlibrary.org/b/id/${it.coverId}-M.jpg"
                )
            } ?: emptyList()
        )
    }
}