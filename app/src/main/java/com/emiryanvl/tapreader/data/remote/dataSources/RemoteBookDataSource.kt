package com.emiryanvl.tapreader.data.remote.dataSources

import com.emiryanvl.tapreader.domain.models.Book
import kotlinx.coroutines.flow.Flow

interface RemoteBookDataSource {

    fun getQueryBooks(query: String): Flow<List<Book>>
}