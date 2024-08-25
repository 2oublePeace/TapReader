package com.emiryanvl.tapreader.data.remote.responses

data class GoogleBookApiResponse(
    val kind: String,
    val totalItems: Int,
    val items: List<Item>
)

data class Item(
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String?,
    val authors: List<String>?,
    val description: String?,
    val categories: List<String>?,
    val industryIdentifiers: List<IndustryIdentifier>,
    val imageLinks: ImageLinks?
)

data class IndustryIdentifier(
    val type: String,
    val identifier: String
)

data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String
)