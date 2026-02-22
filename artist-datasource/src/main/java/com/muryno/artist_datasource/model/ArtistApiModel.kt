package com.muryno.artist_datasource.model

import com.google.gson.annotations.SerializedName

/**
 * API model representing an artist from the MusicBrainz database.
 * Contains comprehensive information about an artist including metadata, geographic data,
 * and identification information.
 *
 * @property aliases List of alternative names for the artist
 * @property area Geographic area associated with the artist
 * @property beginArea Area where the artist was founded/born
 * @property disambiguation Additional text to distinguish between similar artists
 * @property state State or province information
 * @property country Country code for the artist
 * @property gender Gender of the artist (for individuals)
 * @property genderId Unique identifier for the gender
 * @property id Unique MusicBrainz identifier for the artist
 * @property ipis List of IPI (Interested Parties Information) codes
 * @property isnis List of ISNI (International Standard Name Identifier) codes
 * @property lifeSpan Birth and death dates or formation period
 * @property name Primary name of the artist
 * @property score Relevance score from search results
 * @property sortName Name formatted for sorting
 * @property tags List of tags describing the artist
 * @property type Artist type (e.g., Person, Group, Orchestra)
 * @property typeId Unique identifier for the artist type
 */
data class ArtistApiModel(
        val aliases: List<Aliase>?,
        val area: Area?,
        @SerializedName("begin-area") val beginArea: BeginArea?,
        val disambiguation: String?,
        val state: String?,
        val country: String?,
        val gender: String?,
        @SerializedName("gender-id") val genderId: String,
        val id: String,
        val ipis: List<String>,
        val isnis: List<String>,
        @SerializedName("life-span") val lifeSpan: LifeSpanXX?,
        val name: String?,
        val score: Int?,
        @SerializedName("sort-name") val sortName: String,
        val tags: List<Tag>,
        val type: String,
        @SerializedName("type-id") val typeId: String
)
