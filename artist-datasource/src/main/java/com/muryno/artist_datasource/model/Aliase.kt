package com.muryno.artist_datasource.model

import com.google.gson.annotations.SerializedName

data class Aliase(
    @SerializedName("begin-date")
    val beginDate: Any,
    @SerializedName("end-date")
    val endDate: Any,
    val locale: Any,
    @SerializedName("name")
    val name: String,
    val primary: Any,
    @SerializedName("sort-name")
    val sortName: String,
    val type: String,
    @SerializedName("type-id")
    val type_id: String
)