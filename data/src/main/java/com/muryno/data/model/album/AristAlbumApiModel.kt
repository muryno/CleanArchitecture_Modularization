package com.muryno.data.model.album

import com.google.gson.annotations.SerializedName

data class AristAlbumApiModel(
    @SerializedName("release-group-count")
    val releaseGroupCount: Int,
    @SerializedName("release-group-offset")
    val releaseGroupOffset: Int,
    @SerializedName("release_groups")
    val albumReleaseGroupApiModels: List<AlbumReleaseGroupApiModel>
)