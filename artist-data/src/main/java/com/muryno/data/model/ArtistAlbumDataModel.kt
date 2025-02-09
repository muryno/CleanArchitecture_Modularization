package com.muryno.data.model

data class ArtistAlbumDataModel(
    val primaryType: String,

    val genre: String,

    val label: String,

    val shortDescription: String,

    val fullDescription: String,

    val albumImage: String,

    val releaseDate: String,

    val title: String,

    val id: String,
    
    val disambiguation: String
)