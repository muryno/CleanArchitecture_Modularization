package com.muryno.domain.usecase

import com.muryno.domain.repository.ArtistRepository
import javax.inject.Inject


class ArtistUseCase @Inject constructor(
    private val artistRepository: ArtistRepository
) {
    suspend fun execute(artistName: String) = artistRepository.artistList(artistName)
}