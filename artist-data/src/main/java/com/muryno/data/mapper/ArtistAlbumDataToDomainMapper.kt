package com.muryno.data.mapper

import com.muryno.data.model.ArtistAlbumDataModel
import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel

class ArtistAlbumDataToDomainMapper {
    fun toDomain(input: ArtistAlbumDataModel): ArtistAlbumDomainModel {
        return ArtistAlbumDomainModel(
            id = input.id,
            genre = input.genre,
            label = input.label,
            shortDescription = input.shortDescription,
            fullDescription = input.fullDescription,
            albumImage = input.albumImage,
            primaryType = input.primaryType,
            title = input.title,
            releaseDate = input.releaseDate,
            disambiguation = input.disambiguation
        )
    }
}
