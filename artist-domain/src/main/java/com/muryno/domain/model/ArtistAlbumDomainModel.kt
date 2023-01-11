package com.muryno.domain.model


data class ArtistAlbumDomainModel(
    val primaryType: String,
    val releaseDate: String,
    val title: String,
    val id: String,
    val disambiguation: String
)