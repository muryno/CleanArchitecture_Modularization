package com.muryno.artist_datasource.model

import com.google.gson.annotations.SerializedName

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