package com.muryno.presention.artist.model

import java.io.Serializable


data class ArtistPresentationModel(
    val id: String,
    val name: String,
    val gender: String,
    val city: String,
    val state: String,
    val description: String,
    val score: Int
) : Serializable