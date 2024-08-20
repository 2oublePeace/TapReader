package com.emiryanvl.tapreader.data.remote.dataSources

import com.emiryanvl.tapreader.domain.models.Book

interface RemoteBookDataSource {

    suspend fun getFilteredBooks(query: String): List<Book>
}