package com.muryno.artist_datasource.model

/**
 * API response model for artist search results from MusicBrainz.
 *
 * @property artists List of artist results matching the search query
 * @property count Total number of results found
 * @property created Timestamp when the response was created
 * @property offset Pagination offset for the results
 */
data class ArtistListApiModel(
    val artists: List<ArtistApiModel>,
    val count: Int,
    val created: String,
    val offset: Int
)