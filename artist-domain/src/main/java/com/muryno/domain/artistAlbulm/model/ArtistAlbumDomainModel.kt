package com.muryno.domain.artistAlbulm.model


data class ArtistAlbumDomainModel(
    val primaryType: String,
    val releaseDate: String,
    val title: String,
    val id: String,
    val disambiguation: String
)