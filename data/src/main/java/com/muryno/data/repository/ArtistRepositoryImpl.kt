package com.muryno.data.repository


import com.muryno.data.datasource.ArtistRemoteDataSource
import com.muryno.data.mapper.ArtistAlbumApiDataToDomainMapper
import com.muryno.data.mapper.ArtistApiDataToDomainMapper
import com.muryno.data.utils.CoroutineContextProvider
import com.muryno.domain.model.ArtistAlbumDomainModel
import com.muryno.domain.model.ArtistDomainModel
import com.muryno.domain.repository.ArtistRepository
import kotlinx.coroutines.withContext


class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistApiDataToDomainMapper: ArtistApiDataToDomainMapper,
    private val artistAlbumApiDataToDomainMapper: ArtistAlbumApiDataToDomainMapper,
    private val coroutine: CoroutineContextProvider
) : ArtistRepository {

    override suspend fun artistList(artistName: String): List<ArtistDomainModel> =
        withContext(coroutine.io) {
            artistRemoteDataSource.getArtistListFromApi(artistName).artists.map(
                artistApiDataToDomainMapper::toDomain
            )
        }


    override suspend fun artistAlbum(artistId: String, type: String): List<ArtistAlbumDomainModel> =
        withContext(coroutine.io) {
            artistRemoteDataSource.getArtistAlbumFromServer(
                artistId,
                type
            ).albumReleaseGroupApiModels.map(artistAlbumApiDataToDomainMapper::toDomain)
        }

}