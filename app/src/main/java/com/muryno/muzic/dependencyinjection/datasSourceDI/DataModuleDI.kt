package com.muryno.muzic.dependencyinjection.datasSourceDI

import com.muryno.data.api.MusicApiService
import com.muryno.data.datasource.ArtistRemoteDataSource
import com.muryno.data.datasource.ArtistRemoteDataSourceImpl
import com.muryno.data.mapper.ArtistAlbumApiDataToDomainMapper
import com.muryno.data.mapper.ArtistApiDataToDomainMapper
import com.muryno.data.repository.ArtistRepositoryImpl
import com.muryno.data.utils.CoroutineContextProvider
import com.muryno.domain.repository.ArtistRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DataModuleDI {

    @Provides
    fun providersArtistRemoteDataSourceImpl(musicApiService: MusicApiService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            musicApiService
        )
    }

    @Provides
    fun providersTrendingGithubUserRepositoryImpl(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistApiDataToDomainMapper: ArtistApiDataToDomainMapper,
        artistAlbumApiDataToDomainMapper: ArtistAlbumApiDataToDomainMapper,
        coroutine: CoroutineContextProvider

    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource = artistRemoteDataSource,
            artistApiDataToDomainMapper = artistApiDataToDomainMapper,
            artistAlbumApiDataToDomainMapper = artistAlbumApiDataToDomainMapper,
            coroutine = coroutine
        )
    }

}