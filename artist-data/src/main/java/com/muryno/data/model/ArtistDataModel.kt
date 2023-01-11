package com.muryno.data.model


data class ArtistDataModel(
    val id: String,
    val name: String,
    val gender: String,
    val type: String,
    val state: String,
    val disambiguation: String,
    val score: Int
)