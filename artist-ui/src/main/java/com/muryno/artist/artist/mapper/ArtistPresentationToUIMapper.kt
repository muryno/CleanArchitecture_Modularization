package com.muryno.artist.artist.mapper


import com.muryno.artist.artist.model.ArtistUIModel
import com.muryno.presention.artist.model.ArtistPresentationModel
class ArtistPresentationToUIMapper {
    fun toUi(input: ArtistPresentationModel): ArtistUIModel {
        return ArtistUIModel(
            id = input.id,
            name = input.name,
            gender = input.gender,
            city = input.city,
            state = input.name,
            description = input.description,
            score = input.score
        )
    }
}
