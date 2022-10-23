package com.muryno.data.api


import com.muryno.data.model.ArtistListApiModel
import com.muryno.data.model.album.AristAlbumApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicApiService {
    @GET("/artist")
    suspend fun fetchArtistFromServer(
        @Query("query") artistName: String,
        @Query("fmt") fmt: String = "json"
    ): ArtistListApiModel


    @GET("/release-group")
    suspend fun fetchArtistAlbumFromServer(
        @Query("artist") artistId: String,
        @Query("type") type: String,
        @Query("fmt") fmt: String = "json"
    ): AristAlbumApiModel

}