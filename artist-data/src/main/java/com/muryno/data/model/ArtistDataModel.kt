package com.muryno.data.model

import java.io.Serializable

/**
 * Data layer model representing artist information.
 * This model is used in the data layer to transfer artist data between
 * the data source and repository.
 *
 * @property id Unique identifier for the artist
 * @property name Name of the artist
 * @property gender Gender of the artist (if applicable)
 * @property type Type/classification of the artist
 * @property state State or region information
 * @property country Country of origin
 * @property disambiguation Additional information to distinguish similar artists
 * @property score Relevance score from search results
 */
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