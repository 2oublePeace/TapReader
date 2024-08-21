package com.emiryanvl.tapreader.di

import com.emiryanvl.tapreader.data.remote.apiServices.GoogleBooksApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@[Module InstallIn(SingletonComponent::class)]
class NetworkModule {

    @Provides
    fun provideGoogleBooksApi(): GoogleBooksApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(GOOGLE_BOOKS_API_BASE_URL)
        .build()
        .create(GoogleBooksApiService::class.java)

    companion object {
        private const val GOOGLE_BOOKS_API_BASE_URL = "https://www.googleapis.com/books/v1/"
    }
}