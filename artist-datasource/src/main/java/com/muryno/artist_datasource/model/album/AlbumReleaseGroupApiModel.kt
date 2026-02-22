package com.muryno.artist_datasource.model.album

import com.google.gson.annotations.SerializedName

/**
 * API model representing an album release group from MusicBrainz.
 * A release group represents all releases of the same album across different formats.
 *
 * @property disambiguation Text to distinguish between similarly titled albums
 * @property firstReleaseDate Date of the first release in this group
 * @property id Unique MusicBrainz identifier for the release group
 * @property primaryType Primary type of the release (e.g., Album, Single, EP)
 * @property primaryTypeId Unique identifier for the primary type
 * @property secondaryTypeIds List of secondary type identifiers
 * @property secondaryTypes List of secondary release types (e.g., Compilation, Live)
 * @property title Title of the album/release group
 * @property genre Musical genre classification
 * @property label Record label that released the album
 */
data class AlbumReleaseGroupApiModel(
        val disambiguation: String,
        @SerializedName("first-release-date") val firstReleaseDate: String,
        val id: String,
        @SerializedName("primary-type") val primaryType: String,
        @SerializedName("primary-type-id") val primaryTypeId: String,
        @SerializedName("secondary-type-ids") val secondaryTypeIds: List<String>,
        @SerializedName("secondary-types") val secondaryTypes: List<String>,
        val title: String,
        val genre: String?,
        val label: String?
)
