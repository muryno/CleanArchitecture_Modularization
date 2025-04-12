package com.muryno.presention.artist.mapper

import com.muryno.domain.artist.model.ArtistDomainModel
import com.muryno.presention.artist.model.ArtistPresentationModel


class ArtistDomainToPresentationMapper {
    fun toPresentation(input: ArtistDomainModel): ArtistPresentationModel {
        return ArtistPresentationModel(
            id = input.id,
            name = input.name,
            gender = input.gender,
            city = input.type,
            state = input.name,
            description = input.disambiguation,
            score = input.score,
            country = input.country
        )
    }
}
