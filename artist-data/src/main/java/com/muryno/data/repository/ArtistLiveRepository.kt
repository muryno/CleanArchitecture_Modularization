package com.muryno.data.repository


import com.muryno.data.datasource.ArtistDataSource
import com.muryno.data.mapper.ArtistAlbumDataToDomainMapper
import com.muryno.data.mapper.ArtistDataToDomainMapper
import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel
import com.muryno.domain.artist.model.ArtistDomainModel
import com.muryno.domain.artist.repository.ArtistRepository

/**
 * Repository implementation for managing artist data operations.
 * This class implements the [ArtistRepository] interface from the domain layer,
 * coordinating between the data source and mappers to provide domain models.
 *
 * @property artistDataSource Data source for fetching raw artist data
 * @property artistDataToDomainMapper Mapper for converting artist data models to domain models
 * @property artistAlbumDataToDomainMapper Mapper for converting album data models to domain models
 */
class ArtistLiveRepository(
    private val artistDataSource: ArtistDataSource,
    private val artistDataToDomainMapper: ArtistDataToDomainMapper,
    private val artistAlbumDataToDomainMapper: ArtistAlbumDataToDomainMapper,
) : ArtistRepository {

    /**
     * Retrieves a list of artists matching the search query and maps them to domain models.
     *
     * @param artistName The name of the artist to search for
     * @return List of [ArtistDomainModel] containing matching artists
     */
    override suspend fun artistList(artistName: String): List<ArtistDomainModel> =
        artistDataSource.getArtistListFromApi(artistName).map(
            artistDataToDomainMapper::toDomain
        )


    /**
     * Retrieves album releases for a specific artist and maps them to domain models.
     *
     * @param artistId The unique identifier of the artist
     * @return List of [ArtistAlbumDomainModel] containing the artist's albums
     */
    override suspend fun artistAlbum(artistId: String): List<ArtistAlbumDomainModel> =
        artistDataSource.getArtistAlbumFromApi(
            artistId
        ).map(artistAlbumDataToDomainMapper::toDomain)

}