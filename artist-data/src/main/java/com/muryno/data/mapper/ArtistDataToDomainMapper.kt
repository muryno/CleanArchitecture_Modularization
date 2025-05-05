package com.muryno.data.mapper

import com.muryno.data.model.ArtistDataModel
import com.muryno.domain.artist.model.ArtistDomainModel

/**
 * Mapper class for converting artist data models to domain models.
 * Transforms [ArtistDataModel] from the data layer into [ArtistDomainModel]
 * used in the domain layer.
 */
class ArtistDataToDomainMapper {
     /**
      * Converts an [ArtistDataModel] to an [ArtistDomainModel].
      *
      * @param input The artist data model to convert
      * @return [ArtistDomainModel] with mapped artist information
      */
     fun toDomain(input: ArtistDataModel): ArtistDomainModel {
        return ArtistDomainModel(
            id = input.id,
            name = input.name,
            gender = input.gender,
            type = input.type,
            state = input.state,
            country = input.country,
            disambiguation = input.disambiguation,
            score = input.score
        )
    }
}
