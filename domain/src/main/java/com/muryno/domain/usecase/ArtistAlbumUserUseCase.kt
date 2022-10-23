package com.muryno.domain.usecase

import com.muryno.domain.repository.ArtistRepository
import javax.inject.Inject


class ArtistAlbumUserUseCase @Inject constructor(
    private val artistRepository: ArtistRepository) {
    suspend fun execute(artistId: String, type : String) =  artistRepository.artistAlbum(artistId, type = type)
}