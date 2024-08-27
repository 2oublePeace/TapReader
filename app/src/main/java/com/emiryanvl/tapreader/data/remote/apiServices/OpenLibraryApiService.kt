package com.emiryanvl.tapreader.data.remote.apiServices

import com.emiryanvl.tapreader.data.remote.responses.openLibrary.OpenLibrarySubjectApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenLibraryApiService {

    @GET("search")
    suspend fun getBooksByQuery(@Query("q") query: String): Response<OpenLibrarySubjectApiResponse>

    @GET("subjects/{subject}.json")
    suspend fun getBooksBySubject(@Path("subject") subject: String): Response<OpenLibrarySubjectApiResponse>
}