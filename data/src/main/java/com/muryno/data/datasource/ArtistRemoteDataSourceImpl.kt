package com.muryno.data.datasource

import com.muryno.data.api.MusicApiService
import com.muryno.data.model.ArtistListApiModel
import com.muryno.data.model.album.AristAlbumApiModel

class ArtistRemoteDataSourceImpl(
    private val musicApiService: MusicApiService,
) : ArtistRemoteDataSource {
    override suspend fun getArtistListFromApi(artistName: String): ArtistListApiModel =
        musicApiService.fetchArtistFromServer(artistName = artistName)

    override suspend fun getArtistAlbumFromServer(
        artistId: String
    ): AristAlbumApiModel =
        musicApiService.fetchArtistAlbumFromServer(artistId = artistId)
}

