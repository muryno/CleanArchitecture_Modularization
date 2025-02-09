package com.muryno.data.model

import java.io.Serializable


data class ArtistDataModel(
    val id: String,
    val name: String,
    val gender: String,
    val type: String,
    val state: String,
    val country: String,
    val disambiguation: String,
    val score: Int
): Serializable