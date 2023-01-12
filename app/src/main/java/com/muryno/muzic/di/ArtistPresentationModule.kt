package com.muryno.muzic.di

import com.muryno.domain.artist.repository.ArtistRepository
import com.muryno.domain.artist.usecase.ArtistUseCase
import com.muryno.domain.artistAlbulm.usecase.ArtistAlbumUserUseCase
import com.muryno.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import com.muryno.presention.artist.mapper.ArtistDomainToPresentationMapper
import com.muryno.presention.artistAlbulm.mapper.ArtistAlbumDomainToPresentationMapper
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
    fun providesArtistAlbumDomainToPresentationMapper() =
        ArtistAlbumDomainToPresentationMapper()

    @Provides
    fun providesArtistUseCase(
        artistRepository: ArtistRepository,
        coroutineContextProvider: CoroutineContextProvider
    ) = ArtistUseCase(
        artistRepository,
        coroutineContextProvider
    )

    @Provides
    fun providesArtistAlbumUserUseCase (
        artistRepository: ArtistRepository,
        coroutineContextProvider: CoroutineContextProvider
    ) = ArtistAlbumUserUseCase(
        artistRepository,
        coroutineContextProvider
    )

}
