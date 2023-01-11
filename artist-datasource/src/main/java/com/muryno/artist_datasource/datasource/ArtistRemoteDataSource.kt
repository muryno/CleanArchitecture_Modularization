package com.muryno.artist_datasource.datasource

import com.muryno.artist_datasource.api.MusicApiService
import com.muryno.artist_datasource.mapper.ArtistAlbumApiToResponseDataMapper
import com.muryno.artist_datasource.mapper.ArtistApiToResponseDataMapper
import com.muryno.data.datasource.ArtistDataSource
import com.muryno.data.model.ArtistAlbumDataModel
import com.muryno.data.model.ArtistDataModel


class ArtistRemoteDataSource(
    private val musicApiService: MusicApiService,
    private val artistAlbumApiToResponseDataMapper: ArtistAlbumApiToResponseDataMapper,
    private val artistApiToResponseDataMapper: ArtistApiToResponseDataMapper
) : ArtistDataSource {
    override suspend fun getArtistListFromApi(artistName: String): List<ArtistDataModel> {
        val data =  musicApiService.fetchArtistFromServer(artistName = artistName)
        return data.artists.map { artistApiToResponseDataMapper.toData(it) }
    }


    override suspend fun getArtistAlbumFromServer(
        artistId: String
    ): List<ArtistAlbumDataModel> {
        val data = musicApiService.fetchArtistAlbumFromServer(artistId = artistId)
        return data.albumReleaseGroupApiModels.map { artistAlbumApiToResponseDataMapper.toData(it) }
    }

}

