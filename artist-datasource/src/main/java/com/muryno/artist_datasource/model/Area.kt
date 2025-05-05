package com.muryno.artist_datasource.model

import com.google.gson.annotations.SerializedName

/**
 * API model representing a geographic area in MusicBrainz.
 *
 * @property id Unique identifier for the area
 * @property lifeSpan Time period the area existed (for historical areas)
 * @property name Name of the area
 * @property sortName Name formatted for sorting
 * @property type Type of area (e.g., Country, City, State)
 * @property typeId Unique identifier for the area type
 */
data class Area(
    val id: String,
    @SerializedName("life-span")
    val lifeSpan: LifeSpan?,
    val name: String?,
    @SerializedName("sort-name")
    val sortName: String,
    @SerializedName("type")
    val type: String?,
    @SerializedName("type-id")
    val typeId: String
)