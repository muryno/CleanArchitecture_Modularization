package com.muryno.data.model

import com.google.gson.annotations.SerializedName

data class Area(
    val id: String,
    @SerializedName("life-span")
    val life_span: LifeSpan?,
    val name: String,
    @SerializedName("sort-name")
    val sort_name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("type-id")
    val type_id: String
)