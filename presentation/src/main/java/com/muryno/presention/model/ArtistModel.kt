package com.muryno.presention.model


data class ArtistModel(
    val id: String,
    val name: String,
    val gender: String,
    val type: String,
    val state: String,
    val disambiguation: String,
    val score: Int
)