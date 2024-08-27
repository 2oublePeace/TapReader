package com.emiryanvl.tapreader.data.remote.responses.openLibrary

import com.google.gson.annotations.SerializedName

data class OpenLibrarySearchApiResponse(
    @SerializedName("docs")
    val docs: List<Doc>
)

data class Doc(
    @SerializedName("title")
    val title: String
)
