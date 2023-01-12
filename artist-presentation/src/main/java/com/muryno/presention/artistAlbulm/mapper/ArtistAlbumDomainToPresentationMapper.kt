package com.muryno.presention.artistAlbulm.mapper

import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel
import com.muryno.presention.artistAlbulm.model.ArtistAlbumPresentationModel


class ArtistAlbumDomainToPresentationMapper{
     fun toPresentation(input: ArtistAlbumDomainModel): ArtistAlbumPresentationModel {
        return ArtistAlbumPresentationModel(
            id = input.id,
            primaryType = input.primaryType,
            title = input.title,
            releaseDate = input.releaseDate,
            disambiguation = input.disambiguation
        )
    }
}
