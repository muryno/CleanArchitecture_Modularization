package com.muryno.artist_datasource.mapper

import com.muryno.artist_datasource.model.album.AlbumReleaseGroupApiModel
import com.muryno.data.model.ArtistAlbumDataModel


class ArtistAlbumApiToResponseDataMapper {
    fun toData(input: AlbumReleaseGroupApiModel): ArtistAlbumDataModel {
        return ArtistAlbumDataModel(
            id = input.id,
            primaryType = input.primaryType,
            title = input.title,
            genre = input.genre.orEmpty(),
            label = input.label.orEmpty(),
            releaseDate = input.firstReleaseDate,
            disambiguation = input.disambiguation,
            shortDescription = "",
            fullDescription = "",
            albumImage = ""
        )
    }
}
