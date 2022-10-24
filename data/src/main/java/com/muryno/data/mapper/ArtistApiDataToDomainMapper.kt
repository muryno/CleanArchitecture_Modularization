package com.muryno.data.mapper


import com.muryno.data.model.ArtistApiModel
import com.muryno.data.utils.ApiDataToDomainMapper
import com.muryno.domain.model.ArtistDomainModel


class ArtistApiDataToDomainMapper :
    ApiDataToDomainMapper<ArtistApiModel, ArtistDomainModel>() {
    override fun map(input: ArtistApiModel): ArtistDomainModel {
        return ArtistDomainModel(
            id = input.id,
            name = input.name,
            gender = input.gender,
            type = input.area.type,
            state = input.area.name,
            disambiguation = input.disambiguation,
            score = input.score
        )
    }
}
