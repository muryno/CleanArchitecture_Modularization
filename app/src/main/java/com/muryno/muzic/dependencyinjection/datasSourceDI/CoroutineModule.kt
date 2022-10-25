package com.muryno.muzic.dependencyinjection.datasSourceDI

import com.muryno.data.utils.CoroutineContextProvider
import com.muryno.data.utils.DispatchersCoroutineContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CoroutineModule {

    @Provides
    fun providerDispatchersCoroutineContextProvider(): CoroutineContextProvider =
        DispatchersCoroutineContextProvider()
}