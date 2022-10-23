package com.muryno.domain.repository

import com.muryno.domain.model.ArtistAlbumDomainModel
import com.muryno.domain.model.ArtistDomainModel


interface ArtistRepository {
    suspend fun artistList(artistName: String): List<ArtistDomainModel>

    suspend fun artistAlbum(artistId: String,type: String): List<ArtistAlbumDomainModel>
}