package com.muryno.artist_datasource.mapper

import com.muryno.artist_datasource.model.ArtistApiModel
import com.muryno.data.model.ArtistDataModel


class ArtistApiToResponseDataMapper {
  fun toData(input: ArtistApiModel): ArtistDataModel {
        return ArtistDataModel(
            id = input.id,
            name = input.name ?: "",
            gender = input.gender ?: "",
            type = input.area?.sort_name ?: "",
            state = input.area?.name ?: "",
            disambiguation = input.disambiguation ?: "",
            score = input.score ?: 0
        )
    }
}
