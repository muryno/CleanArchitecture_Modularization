package com.muryno.artist_datasource.model.album

import com.google.gson.annotations.SerializedName

data class AristAlbumApiModel(
    @SerializedName("release-group-count")
    val releaseGroupCount: Int,
    @SerializedName("release-group-offset")
    val releaseGroupOffset: Int,
    @SerializedName("release-groups")
    val albumReleaseGroupApiModels: List<AlbumReleaseGroupApiModel>
)