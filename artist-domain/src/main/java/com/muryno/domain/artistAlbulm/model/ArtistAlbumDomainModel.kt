package com.muryno.domain.artistAlbulm.model

/**
 * Domain model representing album information in the business logic layer.
 * This model encapsulates album data used throughout the domain layer,
 * independent of data sources or presentation concerns.
 *
 * @property primaryType Primary type of the release (Album, Single, EP, etc.)
 * @property genre Musical genre of the album
 * @property releaseDate Date when the album was released
 * @property label Record label that released the album
 * @property title Title of the album
 * @property shortDescription Brief description of the album
 * @property fullDescription Complete description of the album
 * @property albumImage URL or path to the album cover image
 * @property id Unique identifier for the album
 * @property disambiguation Additional text to distinguish similar albums
 */
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
