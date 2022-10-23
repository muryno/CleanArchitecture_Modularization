package com.muryno.data.datasource


import com.muryno.data.model.ArtistListApiModel
import com.muryno.data.model.album.AristAlbumApiModel
import retrofit2.Response
import retrofit2.http.Query

interface ArtistRemoteDataSource {
    suspend fun getArtistListFromApi(artistName: String): ArtistListApiModel
    suspend fun getArtistAlbumFromServer(artistId: String,type: String): AristAlbumApiModel
}