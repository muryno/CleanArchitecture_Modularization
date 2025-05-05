package com.muryno.artist_datasource.model

import com.google.gson.annotations.SerializedName

/**
 * API model representing the starting/birth area of an artist.
 * Contains geographic information about where an artist was founded or born.
 *
 * @property id Unique identifier for the area
 * @property lifeSpan Historical period information for the area
 * @property name Name of the area
 * @property sortName Name formatted for sorting
 * @property type Type of area (e.g., Country, City)
 * @property typeId Unique identifier for the area type
 */
data class BeginArea(
    val id: String,
    @SerializedName("life-span")
    val lifeSpan: LifeSpan,
    val name: String,
    @SerializedName("sort-name")
    val sortName: String,
    val type: String,
    @SerializedName("type-id")
    val typeId: String
)