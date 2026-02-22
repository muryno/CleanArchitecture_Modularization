package com.muryno.artist_datasource.model

import com.google.gson.annotations.SerializedName

/**
 * API model representing an alternative name or alias for an artist.
 *
 * @property beginDate Date when this alias started being used
 * @property endDate Date when this alias stopped being used
 * @property locale Language/region code for the alias
 * @property name The alias name
 * @property primary Whether this is the primary name in its locale
 * @property sortName Alias name formatted for sorting
 * @property type Type of alias (e.g., Legal name, Stage name)
 * @property typeId Unique identifier for the alias type
 */
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
    val typeId: String
)