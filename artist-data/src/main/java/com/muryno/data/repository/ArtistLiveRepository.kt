package com.muryno.data.repository


import com.muryno.data.datasource.ArtistDataSource
import com.muryno.data.mapper.ArtistAlbumDataToDomainMapper
import com.muryno.data.mapper.ArtistDataToDomainMapper
import com.muryno.domain.model.ArtistAlbumDomainModel
import com.muryno.domain.model.ArtistDomainModel
import com.muryno.domain.repository.ArtistRepository


class ArtistLiveRepository(
    private val artistDataSource: ArtistDataSource,
    private val artistDataToDomainMapper: ArtistDataToDomainMapper,
    private val artistAlbumDataToDomainMapper: ArtistAlbumDataToDomainMapper,
) : ArtistRepository {

    override suspend fun artistList(artistName: String): List<ArtistDomainModel> =
        artistDataSource.getArtistListFromApi(artistName).map(
            artistDataToDomainMapper::toDomain
        )


    override suspend fun artistAlbum(artistId: String): List<ArtistAlbumDomainModel> =
        artistDataSource.getArtistAlbumFromServer(
            artistId
        ).map(artistAlbumDataToDomainMapper::toDomain)

}