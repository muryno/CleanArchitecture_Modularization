package com.muryno.data.mapper

import com.muryno.data.model.ArtistDataModel
import com.muryno.domain.artist.model.ArtistDomainModel


class ArtistDataToDomainMapper {
     fun toDomain(input: ArtistDataModel): ArtistDomainModel {
        return ArtistDomainModel(
            id = input.id,
            name = input.name,
            gender = input.gender,
            type = input.type,
            state = input.state ,
            disambiguation = input.disambiguation,
            score = input.score
        )
    }
}
