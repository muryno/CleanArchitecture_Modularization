package com.muryno.muzic.di

import android.content.Context
import com.muryno.artist_datasource.api.MusicApiService
import com.muryno.artist_datasource.datasource.ArtistRemoteDataSource
import com.muryno.artist_datasource.mapper.ArtistAlbumApiToResponseDataMapper
import com.muryno.artist_datasource.mapper.ArtistApiToResponseDataMapper
import com.muryno.data.datasource.ArtistDataSource
import com.muryno.muzic.utils.NetworkConnectionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ArtistDataSourceModule {


    @Provides
    fun providerArtistAlbumApiToResponseDataMapper() =
        ArtistAlbumApiToResponseDataMapper()

    @Provides
    fun providerArtistApiToResponseDataMapper() =
        ArtistApiToResponseDataMapper()



    @Provides
    fun providerArtistRemoteDataSource(
        musicApiService: MusicApiService,
        artistAlbumApiToResponseDataMapper: ArtistAlbumApiToResponseDataMapper,
        artistApiToResponseDataMapper: ArtistApiToResponseDataMapper
    ) : ArtistDataSource = ArtistRemoteDataSource(
        musicApiService,
        artistAlbumApiToResponseDataMapper,
        artistApiToResponseDataMapper
    )
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://musicbrainz.org/")
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): MusicApiService {
        return retrofit.create(MusicApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .build()
                chain.proceed(newRequest)
            }
            .addInterceptor(NetworkConnectionInterceptor(context))
            .addInterceptor(interceptor)
            .build()
    }
}