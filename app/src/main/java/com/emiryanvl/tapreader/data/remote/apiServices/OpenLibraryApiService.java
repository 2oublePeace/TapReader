package com.emiryanvl.tapreader.data.remote.apiServices;

import com.emiryanvl.tapreader.data.remote.responses.OpenLibrarySearchApiResponse;
import com.emiryanvl.tapreader.data.remote.responses.OpenLibrarySubjectApiResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenLibraryApiService {

    @GET("search")
    Call<OpenLibrarySearchApiResponse> getBooksByQuery(@Query("q") String query);

    @GET("subjects/{subject}.json")
    Call<OpenLibrarySubjectApiResponse> getBooksBySubject(@Path("subject") String subject);
}
