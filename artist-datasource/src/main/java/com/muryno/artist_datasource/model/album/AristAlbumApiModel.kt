package com.muryno.artist_datasource.model.album

import com.google.gson.annotations.SerializedName

/**
 * API response model for artist album/release group data from MusicBrainz.
 *
 * @property releaseGroupCount Total number of release groups for the artist
 * @property releaseGroupOffset Pagination offset for release groups
 * @property albumReleaseGroupApiModels List of release group/album data
 */
data class AristAlbumApiModel(
    @SerializedName("release-group-count")
    val releaseGroupCount: Int,
    @SerializedName("release-group-offset")
    val releaseGroupOffset: Int,
    @SerializedName("release-groups")
    val albumReleaseGroupApiModels: List<AlbumReleaseGroupApiModel>
)