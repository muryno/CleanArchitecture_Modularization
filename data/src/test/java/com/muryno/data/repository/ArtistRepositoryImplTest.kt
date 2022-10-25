package com.muryno.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.muryno.data.datasource.ArtistRemoteDataSource
import com.muryno.data.mapper.ArtistAlbumApiDataToDomainMapper
import com.muryno.data.mapper.ArtistApiDataToDomainMapper
import com.muryno.data.model.Area
import com.muryno.data.model.ArtistApiModel
import com.muryno.data.model.ArtistListApiModel
import com.muryno.data.model.album.AlbumReleaseGroupApiModel
import com.muryno.data.model.album.AristAlbumApiModel
import com.muryno.data.utils.fakeCoroutineContextProvider
import com.muryno.domain.model.ArtistAlbumDomainModel
import com.muryno.domain.model.ArtistDomainModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


private val artistListApiModel = ArtistListApiModel(
    created = "",
    artists = arrayListOf(inputArtistApiModel()),
    count = 3,
    offset = 1
)

private val aristAlbumApiModel = AristAlbumApiModel(
    albumReleaseGroupApiModels = arrayListOf(inputAlbumReleaseGroupApiModel()),
    releaseGroupOffset = 1,
    releaseGroupCount = 4
)
private fun inputAlbumReleaseGroupApiModel() = AlbumReleaseGroupApiModel(
    disambiguation = "abc",
    firstReleaseDate = "23-2-2022",
    id = "123",
    primaryType = "music",
    primaryTypeId = "",
    secondaryTypeIds = emptyList(),
    secondaryTypes = emptyList(),
    title = "asder"
)

private val expectedOutputArtistAlbumDomainModel = ArtistAlbumDomainModel(
    disambiguation = "abc",
    id = "123",
    primaryType = "music",
    title = "asder",
    releaseDate = "23-2-2022"
)


private fun inputArtistApiModel() = ArtistApiModel(
    disambiguation = "ader",
    id = "",
    area = Area(
        id = "123",
        life_span = null,
        name = "artist",
        sort_name = "sort",
        type = "wizzy",
        type_id = "234"
    ),
    gender = "male",
    type_id = "",
    type = "",
    tags = emptyList(),
    sort_name = "",
    score = 1,
    name = "",
    life_span = null,
    isnis = emptyList(),
    ipis = emptyList(),
    gender_id = "",
    begin_area = null,
    aliases = emptyList()
)

val expectedOutputArtistDomainModel = ArtistDomainModel(
    disambiguation = "ader",
    id = "123",
    name = "artist",
    type = "wizzy",
    state = "artist",
    score = 1,
    gender = "male"
)



const val artistName = "Wizkid"
const val artistId = "1234"
@RunWith(MockitoJUnitRunner::class)
class ArtistRepositoryImplTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var classUnderTest: ArtistRepositoryImpl


    @Mock
    private lateinit var artistRemoteDataSource: ArtistRemoteDataSource


    @Mock
    private lateinit var artistApiDataToDomainMapper: ArtistApiDataToDomainMapper


    @Mock
    private lateinit var artistAlbumApiDataToDomainMapper: ArtistAlbumApiDataToDomainMapper



    @Before
    fun setup() {
        classUnderTest = ArtistRepositoryImpl(
            artistRemoteDataSource = artistRemoteDataSource,
            artistApiDataToDomainMapper = artistApiDataToDomainMapper,
            artistAlbumApiDataToDomainMapper = artistAlbumApiDataToDomainMapper,
            fakeCoroutineContextProvider
        )
    }


    @Test
    fun `given data  When artistList Then return expectedOutputArtistDomainModel`() = runBlocking {

        val expectedResult = arrayListOf(expectedOutputArtistDomainModel)

        //given
        given(
            artistRemoteDataSource.getArtistListFromApi(artistName = artistName)
        ).willReturn(artistListApiModel)

        given(
            artistApiDataToDomainMapper.toDomain( inputArtistApiModel())
        ).willReturn(expectedOutputArtistDomainModel)


        // When
        val actualCommand = classUnderTest.artistList(artistName = artistName )

        // Then
        assertEquals(expectedResult,  actualCommand)
    }

    @Test
    fun `given data  When artistAlbum Then return expectedOutputArtistDomainModel`() = runBlocking {

        val expectedResult = arrayListOf(expectedOutputArtistAlbumDomainModel)
        //given

        given(
            artistRemoteDataSource.getArtistAlbumFromServer(artistId = artistId, type = "")
        ).willReturn(aristAlbumApiModel)

        given(
            artistAlbumApiDataToDomainMapper.toDomain( inputAlbumReleaseGroupApiModel())
        ).willReturn(expectedOutputArtistAlbumDomainModel)


        // When
        val actualCommand = classUnderTest.artistAlbum(artistId = artistId, type = "" )

        // Then
        assertEquals(expectedResult,  actualCommand)
    }


}