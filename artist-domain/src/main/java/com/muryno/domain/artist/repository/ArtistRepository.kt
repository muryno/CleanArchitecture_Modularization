package com.muryno.domain.artist.repository

import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel
import com.muryno.domain.artist.model.ArtistDomainModel


interface ArtistRepository {
    suspend fun artistList(artistName: String): List<ArtistDomainModel>
    suspend fun artistAlbum(artistId: String): List<ArtistAlbumDomainModel>
}