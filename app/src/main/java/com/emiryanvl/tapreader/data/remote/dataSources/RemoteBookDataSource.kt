package com.emiryanvl.tapreader.data.remote.dataSources

import com.emiryanvl.tapreader.domain.models.Book
import kotlinx.coroutines.flow.Flow

interface RemoteBookDataSource {

    fun getBooksByQuery(query: String): Flow<List<Book>>

    fun getBooksBySubject(subject: String): Flow<List<Book>>
}