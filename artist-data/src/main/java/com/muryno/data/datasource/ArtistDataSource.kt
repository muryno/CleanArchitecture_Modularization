package com.muryno.data.datasource


import com.muryno.data.model.ArtistAlbumDataModel
import com.muryno.data.model.ArtistDataModel

interface ArtistDataSource {
    suspend fun getArtistListFromApi(artistName: String): List<ArtistDataModel>
    suspend fun getArtistAlbumFromApi(artistId: String): List<ArtistAlbumDataModel>
}