package com.muryno.artist_datasource.datasource


import com.muryno.artist_datasource.api.MusicApiService
import com.muryno.artist_datasource.mapper.ArtistAlbumApiToResponseDataMapper
import com.muryno.artist_datasource.mapper.ArtistApiToResponseDataMapper
import com.muryno.artist_datasource.model.ArtistApiModel
import com.muryno.artist_datasource.model.ArtistListApiModel
import com.muryno.artist_datasource.model.album.AlbumReleaseGroupApiModel
import com.muryno.artist_datasource.model.album.AristAlbumApiModel
import com.muryno.data.model.ArtistAlbumDataModel
import com.muryno.data.model.ArtistDataModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner




const val artistName = "Khalid"
const val artistId = "2"

@RunWith(MockitoJUnitRunner::class)
class ArtistDataSourceImplTest {


    private lateinit var classUnderTest: ArtistRemoteDataSource

    @Mock
    private lateinit var musicApiService: MusicApiService

    @Mock
    private lateinit var artistAlbumApiToResponseDataMapper: ArtistAlbumApiToResponseDataMapper

    @Mock
    private lateinit var artistApiToResponseDataMapper: ArtistApiToResponseDataMapper

    @Before
    fun setup() {
        classUnderTest = ArtistRemoteDataSource(
            musicApiService,
            artistAlbumApiToResponseDataMapper,
            artistApiToResponseDataMapper
        )
    }

    @Test
    fun `given expectedResult When getArtistListFromApi Then return expected result`() =
        runBlocking {
            val id = "1"
            val name = "tolu"
            val gender = "male"
            val disambiguation = "test1"
            val artistData = ArtistApiModel(
                aliases = emptyList(),
                area = null,
                beginArea = null,
                disambiguation = disambiguation,
                gender = gender,
                genderId = "1",
                id = id,
                ipis = emptyList(),
                isnis = emptyList(),
                lifeSpan = null,
                name = name,
                score = 20,
                sort_name = "nambia",
                tags = emptyList(),
                type = "",
                type_id = "1"
            )
           val artistListApiData = ArtistListApiModel(
                created = "",
                artists = arrayListOf(
                    artistData
                ),
                count = 3,
                offset = 1
            )
            val expectedResult = ArtistDataModel(
                id = id,
                name = name,
                gender = gender,
                type = "",
                state = "",
                disambiguation = disambiguation,
                score = 20
            )

            // given
            given(
                musicApiService.fetchArtistFromServer(artistName = artistName)
            ).willReturn(artistListApiData)

            given(
                artistApiToResponseDataMapper.toData(artistListApiData.artists.first())
            ).willReturn(expectedResult)

            // When
            val actualNavigationCommand =
                classUnderTest.getArtistListFromApi(artistName = artistName)

            // Then
            assertEquals(expectedResult, actualNavigationCommand.first())
        }

    @Test
    fun `given expectedResult When fetchArtistAlbumFromServer Then return expected result`() =
        runBlocking {

            val primaryType = "tolu"
            val firstReleaseDate = "male"
            val disambiguation = "test"
            val title = "test"
            val aristAlbumApiModelData= AristAlbumApiModel(
                releaseGroupCount = 4,
                albumReleaseGroupApiModels = arrayListOf(
                    AlbumReleaseGroupApiModel(
                        disambiguation = disambiguation,
                        firstReleaseDate = firstReleaseDate,
                        id = "1",
                        primaryType = primaryType,
                        primaryTypeId =  "",
                        secondaryTypeIds = emptyList(),
                        secondaryTypes =  emptyList(),
                        title =  title
                    )
                ),
                releaseGroupOffset = 3,)

            val expectedResult = ArtistAlbumDataModel(
                id = "1",
                primaryType = primaryType,
                title = title,
                releaseDate = firstReleaseDate,
                disambiguation = disambiguation
            )

            // given
            given(
                musicApiService.fetchArtistAlbumFromServer(artistId = artistId)
            ).willReturn(aristAlbumApiModelData)


            given(
                artistAlbumApiToResponseDataMapper.toData(aristAlbumApiModelData.albumReleaseGroupApiModels.first())
            ).willReturn(expectedResult)

            // When
            val actualNavigationCommand =
                classUnderTest.getArtistAlbumFromServer(artistId = artistId)

            // Then
            assertEquals(expectedResult, actualNavigationCommand.first())
        }
}