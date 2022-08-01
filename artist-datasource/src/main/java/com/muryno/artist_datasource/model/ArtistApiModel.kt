package com.muryno.artist_datasource.model

import com.google.gson.annotations.SerializedName

data class ArtistApiModel(
    val aliases: List<Aliase>?,
    val area: Area?,
    @SerializedName("begin-area")
    val beginArea: BeginArea?,
    val disambiguation: String?,
    val state: String,
    val gender: String?,
    @SerializedName("gender-id")
    val genderId: String,
    val id: String,
    val ipis: List<String>,
    val isnis: List<String>,
    @SerializedName("life-span")
    val lifeSpan: LifeSpanXX?,
    val name: String?,
    val score: Int?,
    @SerializedName("sort-name")
    val sortName: String,
    val tags: List<Tag>,
    val type: String,
    @SerializedName("type-id")
    val typeId: String
)