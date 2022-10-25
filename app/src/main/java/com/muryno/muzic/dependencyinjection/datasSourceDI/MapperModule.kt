package com.muryno.muzic.dependencyinjection.datasSourceDI

import com.muryno.data.mapper.ArtistAlbumApiDataToDomainMapper
import com.muryno.data.mapper.ArtistApiDataToDomainMapper
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

}