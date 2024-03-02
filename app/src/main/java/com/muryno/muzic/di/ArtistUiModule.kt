package com.muryno.muzic.di

import com.muryno.artist.artist.mapper.ArtistPresentationToUIMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class ArtistUiModule {
    @Provides
    fun providesArtistPresentationToUIMapper() =
        ArtistPresentationToUIMapper()
}
