package com.muryno.artist_datasource.mapper

import com.muryno.artist_datasource.model.ArtistApiModel
import com.muryno.data.model.ArtistDataModel

/**
 * Mapper class for converting artist API models to data layer models.
 * Transforms [ArtistApiModel] from the MusicBrainz API into [ArtistDataModel]
 * used in the data layer.
 */
class ArtistApiToResponseDataMapper {
  /**
   * Converts an [ArtistApiModel] to an [ArtistDataModel].
   *
   * @param input The artist API model to convert
   * @return [ArtistDataModel] with mapped artist information
   */
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
