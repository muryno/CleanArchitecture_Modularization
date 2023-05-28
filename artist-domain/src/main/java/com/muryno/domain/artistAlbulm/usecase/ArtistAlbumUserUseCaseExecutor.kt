package com.muryno.domain.artistAlbulm.usecase

import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel
import com.muryno.domain.artist.repository.ArtistRepository
import com.muryno.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import com.muryno.domain.cleanarchitecture.usecase.BackgroundUseCaseExecutor


class ArtistAlbumUserUseCaseExecutor (
    private val artistRepository: ArtistRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundUseCaseExecutor<String, List<ArtistAlbumDomainModel>>(coroutineContextProvider) {
    override suspend fun executeInBackground(
        request: String
    ) = artistRepository.artistAlbum(request)
}
