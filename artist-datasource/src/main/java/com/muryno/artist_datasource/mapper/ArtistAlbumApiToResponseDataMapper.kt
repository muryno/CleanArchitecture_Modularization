package com.muryno.artist_datasource.mapper

import com.muryno.artist_datasource.model.album.AlbumReleaseGroupApiModel
import com.muryno.data.model.ArtistAlbumDataModel


class ArtistAlbumApiToResponseDataMapper {

    fun toData(input: AlbumReleaseGroupApiModel): ArtistAlbumDataModel {
        return ArtistAlbumDataModel(
            id = input.id,
            primaryType = input.primaryType,
            title = input.title,
            releaseDate = input.firstReleaseDate,
            disambiguation = input.disambiguation
        )
    }
}
