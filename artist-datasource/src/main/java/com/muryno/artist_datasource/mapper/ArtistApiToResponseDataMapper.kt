package com.muryno.artist_datasource.mapper

import com.muryno.artist_datasource.model.ArtistApiModel
import com.muryno.data.model.ArtistDataModel


class ArtistApiToResponseDataMapper {
  fun toData(input: ArtistApiModel): ArtistDataModel {
        return ArtistDataModel(
            id = input.id,
            name = input.name.orEmpty(),
            gender = input.gender.orEmpty(),
            type = input.area?.sortName.orEmpty(),
            state = input.area?.name.orEmpty(),
            disambiguation = input.disambiguation.orEmpty(),
            score = input.score ?: 0,
            country = input.country.orEmpty()
        )
    }
}
