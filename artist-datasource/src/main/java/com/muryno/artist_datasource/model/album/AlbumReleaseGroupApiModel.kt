package com.muryno.artist_datasource.model.album

import com.google.gson.annotations.SerializedName

data class AlbumReleaseGroupApiModel(
    val disambiguation: String,
    @SerializedName("first-release-date")
    val firstReleaseDate: String,
    val id: String,
    @SerializedName("primary-type")
    val primaryType: String,
    @SerializedName("primary-type-id")
    val primaryTypeId: String,
    @SerializedName("secondary-type-ids")
    val secondaryTypeIds: List<String>,
    @SerializedName("secondary-types")
    val secondaryTypes: List<String>,
    val title: String,
    val genre: String?
)