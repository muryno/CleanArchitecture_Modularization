package com.muryno.artist_datasource.mapper

import com.muryno.artist_datasource.model.album.AlbumReleaseGroupApiModel
import com.muryno.data.model.ArtistAlbumDataModel

/**
 * Mapper class for converting album API models to data layer models.
 * Transforms [AlbumReleaseGroupApiModel] from the MusicBrainz API into [ArtistAlbumDataModel]
 * used in the data layer.
 */
class ArtistAlbumApiToResponseDataMapper {
    /**
     * Converts an [AlbumReleaseGroupApiModel] to an [ArtistAlbumDataModel].
     *
     * @param input The album API model to convert
     * @return [ArtistAlbumDataModel] with mapped album information
     */
    fun toData(input: AlbumReleaseGroupApiModel): ArtistAlbumDataModel {
        return ArtistAlbumDataModel(
            id = input.id,
            primaryType = input.primaryType,
            title = input.title,
            genre = input.genre.orEmpty(),
            label = input.label.orEmpty(),
            releaseDate = input.firstReleaseDate,
            disambiguation = input.disambiguation,
            shortDescription = "",
            fullDescription = "",
            albumImage = ""
        )
    }
}
