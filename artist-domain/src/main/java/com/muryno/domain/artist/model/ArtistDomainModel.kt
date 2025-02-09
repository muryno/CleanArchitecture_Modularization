package com.muryno.domain.artist.model


data class ArtistDomainModel(
    val id: String,
    val name: String,
    val gender: String,
    val type: String,
    val state: String,
    val disambiguation: String,
    val score: Int,
    val country: String
)