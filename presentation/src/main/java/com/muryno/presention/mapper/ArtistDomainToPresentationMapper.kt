package com.muryno.presention.mapper

import com.muryno.domain.model.ArtistDomainModel
import com.muryno.presention.model.ArtistModel
import com.muryno.presention.utils.DomainToPresentationMapper

class ArtistDomainToPresentationMapper : DomainToPresentationMapper<ArtistDomainModel, ArtistModel>() {
    override fun map(input: ArtistDomainModel): ArtistModel {
        return ArtistModel(
            id = input.id,
            name = input.name,
            gender = input.gender,
            city = input.type,
            state = input.name,
            description = input.disambiguation,
            score = input.score
        )
    }
}
