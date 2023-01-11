package com.muryno.artist_datasource.api


import com.muryno.artist_datasource.model.ArtistListApiModel
import com.muryno.artist_datasource.model.album.AristAlbumApiModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MusicApiService {
    @Headers(
        "Accept: application/json",
        "User-Agent: com.ubn.musicbrainz_place/1.0"
    )
    @GET("ws/2/artist")
    suspend fun fetchArtistFromServer(
        @Query("query") artistName: String,
        @Query("fmt") fmt: String = "json"
    ): ArtistListApiModel


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