package com.muryno.artist_datasource.datasource

import com.muryno.artist_datasource.api.MusicApiService
import com.muryno.artist_datasource.mapper.ArtistAlbumApiToResponseDataMapper
import com.muryno.artist_datasource.mapper.ArtistApiToResponseDataMapper
import com.muryno.data.datasource.ArtistDataSource
import com.muryno.data.model.ArtistAlbumDataModel
import com.muryno.data.model.ArtistDataModel

/**
 * Remote data source implementation for fetching artist data from the MusicBrainz API.
 * This class implements the [ArtistDataSource] interface and handles API calls,
 * mapping API models to data layer models.
 *
 * @property musicApiService The Retrofit service for making API requests
 * @property artistAlbumApiToResponseDataMapper Mapper for converting album API models to data models
 * @property artistApiToResponseDataMapper Mapper for converting artist API models to data models
 */
class ArtistRemoteDataSource(
    private val musicApiService: MusicApiService,
    private val artistAlbumApiToResponseDataMapper: ArtistAlbumApiToResponseDataMapper,
    private val artistApiToResponseDataMapper: ArtistApiToResponseDataMapper
) : ArtistDataSource {
    /**
     * Retrieves a list of artists from the API based on the search query.
     *
     * @param artistName The name of the artist to search for
     * @return List of [ArtistDataModel] containing artist information
     */
    override suspend fun getArtistListFromApi(artistName: String): List<ArtistDataModel> {
        val data =  musicApiService.fetchArtistFromServer(artistName = artistName)
        return data.artists.map { artistApiToResponseDataMapper.toData(it) }
    }


    /**
     * Retrieves album releases for a specific artist from the API.
     *
     * @param artistId The unique identifier of the artist
     * @return List of [ArtistAlbumDataModel] containing album information
     */
    override suspend fun getArtistAlbumFromApi(
        artistId: String
    ): List<ArtistAlbumDataModel> {
        val data = musicApiService.fetchArtistAlbumFromServer(artistId = artistId)
        return data.albumReleaseGroupApiModels.map { artistAlbumApiToResponseDataMapper.toData(it) }
    }

}

