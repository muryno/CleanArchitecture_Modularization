package com.muryno.muzic.di

import com.muryno.data.datasource.ArtistDataSource
import com.muryno.data.mapper.ArtistAlbumDataToDomainMapper
import com.muryno.data.mapper.ArtistDataToDomainMapper
import com.muryno.data.repository.ArtistLiveRepository
import com.muryno.domain.artist.repository.ArtistRepository
import com.muryno.domain.artistAlbulm.usecase.ArtistAlbumUserUseCase
import com.muryno.domain.artist.usecase.ArtistUseCase
import com.muryno.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ArtistDataModule {


    @Provides
    fun providerArtistAlbumDataToDomainMapper() =
        ArtistAlbumDataToDomainMapper()

    @Provides
    fun providerArtistDataToDomainMapper() =
        ArtistDataToDomainMapper()

    @Provides
    fun providerArtistLiveRepository(
        artistDataSource: ArtistDataSource,
        artistDataToDomainMapper: ArtistDataToDomainMapper,
        artistAlbumDataToDomainMapper: ArtistAlbumDataToDomainMapper
    ) = ArtistLiveRepository(
        artistDataSource,
        artistDataToDomainMapper,
        artistAlbumDataToDomainMapper
    )


    @Provides
    fun providesArtistAlbumUserUseCase (
        artistRepository: ArtistRepository,
        coroutineContextProvider: CoroutineContextProvider
    ) = ArtistAlbumUserUseCase(
        artistRepository,
        coroutineContextProvider
    )

    @Provides
    fun providesArtistUseCase(
        artistRepository: ArtistRepository,
        coroutineContextProvider: CoroutineContextProvider
    ) = ArtistUseCase(
        artistRepository,
        coroutineContextProvider
    )

}