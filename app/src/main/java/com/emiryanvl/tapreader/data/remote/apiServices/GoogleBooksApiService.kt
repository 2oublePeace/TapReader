package com.emiryanvl.tapreader.data.remote.apiServices

import com.emiryanvl.tapreader.data.remote.responses.google.GoogleBookApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleBooksApiService {

    @GET("volumes")
    suspend fun getBooksByQuery(@Query("q") query: String): Response<GoogleBookApiResponse>
}