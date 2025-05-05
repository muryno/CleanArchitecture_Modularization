package com.muryno.data.datasource

import com.muryno.data.model.ArtistAlbumDataModel
import com.muryno.data.model.ArtistDataModel

/**
 * Data source interface for retrieving artist and album information.
 * This interface defines the contract for fetching data from external sources
 * (typically remote APIs). Implementations handle the actual data retrieval logic.
 */
interface ArtistDataSource {
    /**
     * Retrieves a list of artists matching the search query.
     *
     * @param artistName The name of the artist to search for
     * @return List of [ArtistDataModel] containing matching artists
     */
    suspend fun getArtistListFromApi(artistName: String): List<ArtistDataModel>
    
    /**
     * Retrieves album releases for a specific artist.
     *
     * @param artistId The unique identifier of the artist
     * @return List of [ArtistAlbumDataModel] containing the artist's albums
     */
    suspend fun getArtistAlbumFromApi(artistId: String): List<ArtistAlbumDataModel>
}