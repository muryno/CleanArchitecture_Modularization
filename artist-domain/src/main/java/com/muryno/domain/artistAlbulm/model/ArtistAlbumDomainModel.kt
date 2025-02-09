package com.muryno.domain.artistAlbulm.model

data class ArtistAlbumDomainModel(
        val primaryType: String,
        val genre: String,
        val releaseDate: String,
        val label: String,
        val title: String,
        val shortDescription: String,
        val fullDescription: String,
        val albumImage: String,
        val id: String,
        val disambiguation: String
)
