package com.muryno.muzic.di

import com.muryno.data.datasource.ArtistDataSource
import com.muryno.data.mapper.ArtistAlbumDataToDomainMapper
import com.muryno.data.mapper.ArtistDataToDomainMapper
import com.muryno.data.repository.ArtistLiveRepository
import com.muryno.domain.repository.ArtistRepository
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


}