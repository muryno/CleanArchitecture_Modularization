package com.muryno.presention.mapper

import com.muryno.domain.model.ArtistAlbumDomainModel
import com.muryno.presention.model.ArtistAlbumModel
import com.muryno.presention.utils.DomainToPresentationMapper

class ArtistAlbumDomainToPresentationMapper :
    DomainToPresentationMapper<ArtistAlbumDomainModel, ArtistAlbumModel>() {
    override fun map(input: ArtistAlbumDomainModel): ArtistAlbumModel {
        return ArtistAlbumModel(
            id = input.id,
            primaryType = input.primaryType,
            title = input.title,
            releaseDate = input.releaseDate,
            disambiguation = input.disambiguation
        )
    }
}
