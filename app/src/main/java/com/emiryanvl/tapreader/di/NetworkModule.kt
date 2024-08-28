package com.emiryanvl.tapreader.di

import com.emiryanvl.tapreader.core.GOOGLE_BOOKS_API_BASE_URL
import com.emiryanvl.tapreader.core.OPEN_LIBRARY_API_BASE_URL
import com.emiryanvl.tapreader.data.remote.apiServices.GoogleBooksApiService
import com.emiryanvl.tapreader.data.remote.apiServices.OpenLibraryApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.HTTP
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
class NetworkModule {

    @[Provides Singleton]
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .addInterceptor (
                HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            )
            .build()

    @[Provides Singleton]
    fun provideGoogleBooksApi(client: OkHttpClient): GoogleBooksApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(GOOGLE_BOOKS_API_BASE_URL)
        .client(client)
        .build()
        .create(GoogleBooksApiService::class.java)

    @[Provides Singleton]
    fun provideOpenLibraryApi(client: OkHttpClient): OpenLibraryApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(OPEN_LIBRARY_API_BASE_URL)
        .client(client)
        .build()
        .create(OpenLibraryApiService::class.java)
}