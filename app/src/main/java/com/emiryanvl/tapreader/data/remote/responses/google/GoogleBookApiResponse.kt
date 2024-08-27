package com.emiryanvl.tapreader.data.remote.responses.google

import com.google.gson.annotations.SerializedName

data class GoogleBookApiResponse(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int,
    @SerializedName("items")
    val items: List<Item>
)

data class Item(
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    @SerializedName("title")
    val title: String?,
    @SerializedName("authors")
    val authors: List<String>?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("categories")
    val categories: List<String>?,
    @SerializedName("industryIdentifiers")
    val industryIdentifiers: List<IndustryIdentifier>,
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks?
)

data class IndustryIdentifier(
    @SerializedName("type")
    val type: String,
    @SerializedName("identifier")
    val identifier: String
)

data class ImageLinks(
    @SerializedName("smallThumbnail")
    val smallThumbnail: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)