package com.muryno.muzic.di


import com.muryno.presention.architecture.viewmodel.usecase.UseCaseExecutorProvider
import com.muryno.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import com.muryno.domain.cleanarchitecture.usecase.UseCaseExecutor
import com.muryno.presention.architecture.viewmodel.coroutine.AppCoroutineContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ArchitecturePresentationModule {
    @Provides
    fun providesCoroutineContextProvider(): CoroutineContextProvider =
        AppCoroutineContextProvider()

    @Provides
    fun providesUseCaseExecutorProvider(): UseCaseExecutorProvider = ::UseCaseExecutor
}
