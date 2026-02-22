package com.muryno.domain.artist.repository

import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel
import com.muryno.domain.artist.model.ArtistDomainModel

/**
 * Repository interface for artist-related data operations in the domain layer.
 * This interface defines the contract for accessing artist and album data,
 * abstracting the implementation details from the business logic.
 */
interface ArtistRepository {
    /**
     * Retrieves a list of artists matching the search query.
     *
     * @param artistName The name of the artist to search for
     * @return List of [ArtistDomainModel] containing matching artists
     */
    suspend fun artistList(artistName: String): List<ArtistDomainModel>
    
    /**
     * Retrieves album releases for a specific artist.
     *
     * @param artistId The unique identifier of the artist
     * @return List of [ArtistAlbumDomainModel] containing the artist's albums
     */
    suspend fun artistAlbum(artistId: String): List<ArtistAlbumDomainModel>
}