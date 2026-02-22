package com.muryno.artist_datasource.model

/**
 * API model representing a tag or genre classification for an artist.
 *
 * @property count Number of users who have applied this tag
 * @property name The tag/genre name
 */
data class Tag(
    val count: Int,
    val name: String
)