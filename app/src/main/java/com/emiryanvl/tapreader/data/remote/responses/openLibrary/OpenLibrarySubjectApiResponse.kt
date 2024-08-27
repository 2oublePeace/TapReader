package com.emiryanvl.tapreader.data.remote.responses.openLibrary

import com.google.gson.annotations.SerializedName

data class OpenLibrarySubjectApiResponse(
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("subject_type")
    val subjectType: String,
    @SerializedName("work_count")
    val workCount: Int,
    @SerializedName("works")
    val works: List<Work>
)

data class Work(
    @SerializedName("key")
    val key: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("cover_id")
    val coverId: Int,
    @SerializedName("authors")
    val authors: List<Author>
)

data class Author(
    @SerializedName("key")
    val key: String,
    @SerializedName("name")
    val name: String
)