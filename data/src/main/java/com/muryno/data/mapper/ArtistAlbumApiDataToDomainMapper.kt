package com.muryno.data.mapper


import com.muryno.data.model.album.AlbumReleaseGroupApiModel
import com.muryno.data.utils.ApiDataToDomainMapper
import com.muryno.domain.model.ArtistAlbumDomainModel

class ArtistAlbumApiDataToDomainMapper :
    ApiDataToDomainMapper<AlbumReleaseGroupApiModel, ArtistAlbumDomainModel>() {
    override fun map(input: AlbumReleaseGroupApiModel): ArtistAlbumDomainModel {
        return ArtistAlbumDomainModel(
            id = input.id,
            primaryType = input.primaryType,
            title = input.title,
            releaseDate = input.firstReleaseDate,
            disambiguation = input.disambiguation
        )
    }
}
