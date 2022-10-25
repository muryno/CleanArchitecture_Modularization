package com.muryno.muzic.dependencyinjection.datasSourceDI

import com.muryno.data.mapper.ArtistAlbumApiDataToDomainMapper
import com.muryno.data.mapper.ArtistApiDataToDomainMapper
import com.muryno.presention.mapper.ArtistAlbumDomainToPresentationMapper
import com.muryno.presention.mapper.ArtistDomainToPresentationMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    fun providerArtistAlbumApiDataToDomainMapper() =
        ArtistAlbumApiDataToDomainMapper()

    @Provides
    fun providerArtistApiDataToDomainMapper() =
        ArtistApiDataToDomainMapper()


    @Provides
    fun providerArtistDomainToPresentationMapper() =
        ArtistDomainToPresentationMapper()

    @Provides
    fun providerArtistAlbumDomainToPresentationMapper() =
        ArtistAlbumDomainToPresentationMapper()

}