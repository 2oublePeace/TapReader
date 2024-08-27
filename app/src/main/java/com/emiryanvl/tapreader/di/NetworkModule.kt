package com.emiryanvl.tapreader.di

import com.emiryanvl.tapreader.core.Constants
import com.emiryanvl.tapreader.data.remote.apiServices.GoogleBooksApiService
import com.emiryanvl.tapreader.data.remote.apiServices.OpenLibraryApiService
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
        .baseUrl(Constants.GOOGLE_BOOKS_API_BASE_URL)
        .build()
        .create(GoogleBooksApiService::class.java)

    @Provides
    fun provideOpenLibraryApi(): OpenLibraryApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.OPEN_LIBRARY_API_BASE_URL)
        .build()
        .create(OpenLibraryApiService::class.java)
}