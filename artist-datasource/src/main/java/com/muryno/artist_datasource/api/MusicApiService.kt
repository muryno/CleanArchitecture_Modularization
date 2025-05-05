package com.muryno.artist_datasource.api


import com.muryno.artist_datasource.model.ArtistListApiModel
import com.muryno.artist_datasource.model.album.AristAlbumApiModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Retrofit service interface for interacting with the MusicBrainz API.
 * Provides endpoints for fetching artist information and album data.
 */
interface MusicApiService {
    /**
     * Fetches a list of artists from the MusicBrainz API based on search query.
     *
     * @param artistName The name of the artist to search for
     * @param fmt Response format (defaults to "json")
     * @return [ArtistListApiModel] containing the list of matching artists
     */
    @Headers(
        "Accept: application/json",
        "User-Agent: com.ubn.musicbrainz_place/1.0"
    )
    @GET("ws/2/artist")
    suspend fun fetchArtistFromServer(
        @Query("query") artistName: String,
        @Query("fmt") fmt: String = "json"
    ): ArtistListApiModel


    /**
     * Fetches album releases for a specific artist from the MusicBrainz API.
     *
     * @param artistId The unique identifier of the artist
     * @param type The type of releases to fetch (defaults to "album")
     * @param fmt Response format (defaults to "json")
     * @return [AristAlbumApiModel] containing the artist's album releases
     */
    @Headers(
        "Accept: application/json",
        "User-Agent: com.ubn.musicbrainz_place/1.0"
    )
    @GET("ws/2/release-group")
    suspend fun fetchArtistAlbumFromServer(
        @Query("artist") artistId: String,
        @Query("type") type: String = "album",
        @Query("fmt") fmt: String = "json"
    ): AristAlbumApiModel

}