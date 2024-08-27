package com.emiryanvl.tapreader.data.remote.dataSources

import com.emiryanvl.tapreader.core.Constants
import com.emiryanvl.tapreader.data.remote.apiServices.GoogleBooksApiService
import com.emiryanvl.tapreader.domain.models.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GoogleBookDataSourceImpl @Inject constructor(
    private val googleBooksApi: GoogleBooksApiService
) : RemoteBookDataSource {

    override fun getBooksByQuery(query: String) = flow {
        emit(
            googleBooksApi.getBooksByQuery(query).body()?.items?.map {
                Book(
                    title = it.volumeInfo.title.toString(),
                    author = it.volumeInfo.authors?.joinToString(separator = Constants.COMMA_SEPARATOR)
                        ?: Constants.EMPTY_STRING,
                    description = it.volumeInfo.description.toString(),
                    genre = it.volumeInfo.categories?.joinToString(separator = Constants.COMMA_SEPARATOR),
                    isbn = it.volumeInfo.industryIdentifiers.first().identifier,
                    imageUri = it.volumeInfo.imageLinks?.thumbnail?.replace(HTTP, HTTPS)
                )
            } ?: emptyList()
        )
    }

    override fun getBooksBySubject(subject: String) = flow {
        val query = SUBJECT_API + subject
        emit(
            googleBooksApi.getBooksByQuery(query).body()?.items?.map {
                Book(
                    title = it.volumeInfo.title.toString(),
                    author = it.volumeInfo.authors?.joinToString(
                        separator = Constants.COMMA_SEPARATOR
                    ) ?: Constants.EMPTY_STRING,
                    description = it.volumeInfo.description.toString(),
                    genre = it.volumeInfo.categories?.joinToString(
                        separator = Constants.COMMA_SEPARATOR
                    ),
                    isbn = it.volumeInfo.industryIdentifiers.first().identifier,
                    imageUri = it.volumeInfo.imageLinks?.thumbnail?.replace(HTTP, HTTPS)
                )
            } ?: emptyList()
        )
    }

    companion object {
        const val SUBJECT_API = "subject:"
        const val HTTP = "http://"
        const val HTTPS = "https://"
    }
}