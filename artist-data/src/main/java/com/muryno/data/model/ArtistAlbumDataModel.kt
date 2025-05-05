package com.muryno.data.model

/**
 * Data layer model representing album/release information for an artist.
 * This model is used in the data layer to transfer album data between
 * the data source and repository.
 *
 * @property primaryType Primary type of the release (Album, Single, EP, etc.)
 * @property genre Musical genre of the album
 * @property label Record label that released the album
 * @property shortDescription Brief description of the album
 * @property fullDescription Complete description of the album
 * @property albumImage URL or path to the album cover image
 * @property releaseDate Date when the album was released
 * @property title Title of the album
 * @property id Unique identifier for the album
 * @property disambiguation Additional text to distinguish similar albums
 */
data class ArtistAlbumDataModel(
    val primaryType: String,

    val genre: String,

    val label: String,

    val shortDescription: String,

    val fullDescription: String,

    val albumImage: String,

    val releaseDate: String,

    val title: String,

    val id: String,
    
    val disambiguation: String
)