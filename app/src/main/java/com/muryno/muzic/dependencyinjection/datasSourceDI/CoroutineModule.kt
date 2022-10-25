package com.muryno.muzic.dependencyinjection.datasSourceDI

import com.muryno.artist.adapter.ArtistAdapter
import com.muryno.data.utils.CoroutineContextProvider
import com.muryno.data.utils.DispatchersCoroutineContextProvider
import com.muryno.presention.model.ArtistModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class CoroutineModule {

    @Provides
    fun providerDispatchersCoroutineContextProvider(): CoroutineContextProvider =
        DispatchersCoroutineContextProvider()

}