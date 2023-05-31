package com.muryno.muzic.di

import com.muryno.domain.artist.repository.ArtistRepository
import com.muryno.domain.artist.usecase.ArtistUseCaseExecutor
import com.muryno.domain.artistAlbulm.usecase.ArtistAlbumUserUseCaseExecutor
import com.muryno.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import com.muryno.presention.artist.mapper.ArtistDomainToPresentationMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ArtistPresentationModule {

    @Provides
    fun providesArtistDomainToPresentationMapper() =
        ArtistDomainToPresentationMapper()



    @Provides
    fun providesArtistUseCase(
        artistRepository: ArtistRepository,
        coroutineContextProvider: CoroutineContextProvider
    ) = ArtistUseCaseExecutor(
        artistRepository,
        coroutineContextProvider
    )

    @Provides
    fun providesArtistAlbumUserUseCase (
        artistRepository: ArtistRepository,
        coroutineContextProvider: CoroutineContextProvider
    ) = ArtistAlbumUserUseCaseExecutor(
        artistRepository,
        coroutineContextProvider
    )

}
