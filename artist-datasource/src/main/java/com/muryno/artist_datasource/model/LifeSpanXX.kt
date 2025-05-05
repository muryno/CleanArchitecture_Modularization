package com.muryno.artist_datasource.model

/**
 * API model representing the life span or active period of an artist.
 *
 * @property begin Start date (birth date for persons, formation date for groups)
 * @property ended Whether the artist is deceased or disbanded
 */
data class LifeSpanXX(
    val begin: String,
    val ended: Any
)