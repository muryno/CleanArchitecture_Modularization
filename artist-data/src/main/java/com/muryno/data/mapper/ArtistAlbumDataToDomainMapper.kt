package com.muryno.data.mapper

import com.muryno.data.model.ArtistAlbumDataModel
import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel

/**
 * Mapper class for converting album data models to domain models.
 * Transforms [ArtistAlbumDataModel] from the data layer into [ArtistAlbumDomainModel]
 * used in the domain layer.
 */
class ArtistAlbumDataToDomainMapper {

    /**
     * Converts an [ArtistAlbumDataModel] to an [ArtistAlbumDomainModel].
     *
     * @param input The album data model to convert
     * @return [ArtistAlbumDomainModel] with mapped album information
     */
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
