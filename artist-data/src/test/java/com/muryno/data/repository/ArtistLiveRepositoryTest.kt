package com.muryno.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.muryno.data.datasource.ArtistDataSource
import com.muryno.data.mapper.ArtistAlbumDataToDomainMapper
import com.muryno.data.mapper.ArtistDataToDomainMapper
import com.muryno.data.model.ArtistAlbumDataModel
import com.muryno.data.model.ArtistDataModel
import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel
import com.muryno.domain.artist.model.ArtistDomainModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


const val artistName = "Wizkid"
const val artistId = "1234"

@RunWith(MockitoJUnitRunner::class)
class ArtistLiveRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var classUnderTest: ArtistLiveRepository


    @Mock
    private lateinit var artistDataSource: ArtistDataSource


    @Mock
    private lateinit var artistDataToDomainMapper: ArtistDataToDomainMapper


    @Mock
    private lateinit var artistAlbumDataToDomainMapper: ArtistAlbumDataToDomainMapper


    @Before
    fun setup() {
        classUnderTest = ArtistLiveRepository(
            artistDataSource,
            artistDataToDomainMapper,
            artistAlbumDataToDomainMapper,
        )
    }


    @Test
    fun `given data  When artistList Then return expectedOutputArtistDomainModel`() = runBlocking {

        val disambiguation = "ader"
        val id = "123"
        val name = "artist"
        val type = "wizzy"
        val state = "artist"
        val gender = "male"

        val artistDataModelData =  arrayListOf(
            ArtistDataModel(
                id = id,
                name = name,
                type = type,
                state = state,
                score = 1,
                gender = gender,
                disambiguation = disambiguation
            )
        )


        val expectedResult = arrayListOf(
            ArtistDomainModel(
                id = id,
                name = name,
                type = type,
                state = state,
                score = 1,
                gender = gender,
                disambiguation = disambiguation
            )
        )



        //given
        given(
            artistDataSource.getArtistListFromApi(artistName = artistName)
        ).willReturn(artistDataModelData)

        given(
            artistDataToDomainMapper.toDomain(artistDataModelData.first())
        ).willReturn(expectedResult.first())


        // When
        val actualCommand = classUnderTest.artistList(artistName = artistName)

        // Then
        assertEquals(expectedResult, actualCommand)
    }



    @Test
    fun `given data  When artistAlbum Then return expectedOutputArtistDomainModel`() = runBlocking {

        val disambiguation = "ader"
        val id = "123"
        val name = "artist"
        val firstReleaseDate = "wizzy"
        val primaryType = "artist"
        val genre: "afro"
        val label: "Republic"
        val shortDescription: "good things"
        val fullDescription: "good things come to everyone"
        val albumImage: "https://img.com" 




        val artistAlbumDataModelList = arrayListOf(
            ArtistAlbumDataModel(
                id = id,
                label = label,
                albumImage = albumImage,
                genre = genre,
                shortDescription = shortDescription
                fullDescription = fullDescription,
                title =  name,
                releaseDate = firstReleaseDate,
                disambiguation = disambiguation,
                primaryType = primaryType
            )
        )

        val expectedResult = arrayListOf(
            ArtistAlbumDomainModel(
                id = id,
                label = label,
                title =  name,
                releaseDate = firstReleaseDate,
                disambiguation = disambiguation,
                primaryType = primaryType
            )
        )
        //given

        given(
            artistDataSource.getArtistAlbumFromApi(artistId = artistId)
        ).willReturn(artistAlbumDataModelList)

        given(
            artistAlbumDataToDomainMapper.toDomain(artistAlbumDataModelList.first())
        ).willReturn(expectedResult.first())


        // When
        val actualCommand = classUnderTest.artistAlbum(artistId = artistId)

        // Then
        assertEquals(expectedResult, actualCommand)
    }


}