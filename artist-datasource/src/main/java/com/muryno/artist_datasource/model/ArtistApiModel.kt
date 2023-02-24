package com.muryno.artist_datasource.model

import com.google.gson.annotations.SerializedName

data class ArtistApiModel(
    val aliases: List<Aliase>?,
    val area: Area?,
    @SerializedName("begin-area")
    val beginArea: BeginArea?,
    val disambiguation: String?,
    val gender: String?,
    @SerializedName("gender-id")
    val gender_id: String,
    val id: String,
    val ipis: List<String>,
    val isnis: List<String>,
    @SerializedName("life-span")
    val life_span: LifeSpanXX?,
    val name: String?,
    val score: Int?,
    @SerializedName("sort-name")
    val sort_name: String,
    val tags: List<Tag>,
    val type: String,
    @SerializedName("type-id")
    val type_id: String
)