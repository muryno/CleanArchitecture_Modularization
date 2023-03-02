package com.muryno.artist_datasource.model

import com.google.gson.annotations.SerializedName

data class Aliase(
    @SerializedName("begin-date")
    val beginDate: Any,
    @SerializedName("end-date")
    val end_date: Any,
    val locale: Any,
    @SerializedName("name")
    val name: String,
    val primary: Any,
    @SerializedName("sort-name")
    val sort_name: String,
    val type: String,
    @SerializedName("type-id")
    val type_id: String
)