package com.muryno.data.datasource

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.muryno.data.api.MusicApiService
import com.muryno.data.model.ArtistListApiModel
import com.muryno.data.model.album.AristAlbumApiModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


private val artistListApiModelOutputResult = ArtistListApiModel(
    created = "",
    artists = emptyList(),
    count = 3,
    offset = 1
)


private val aristAlbumApiModelOutputResult = AristAlbumApiModel(
    releaseGroupCount = 4,
    albumReleaseGroupApiModels = emptyList(),
    releaseGroupOffset = 3,

    )

const val artistName = "Khalid"
const val artistId = "2"

@RunWith(MockitoJUnitRunner::class)
class ArtistRemoteDataSourceImplTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var classUnderTest: ArtistRemoteDataSourceImpl

    @Mock
    private lateinit var musicApiService: MusicApiService

    @Before
    fun setup() {
        classUnderTest = ArtistRemoteDataSourceImpl(
            musicApiService = musicApiService,
        )
    }

    @Test
    fun `given expectedResult When getArtistListFromApi Then return expected result`() =
        runBlocking {

            val expectedResult = artistListApiModelOutputResult
            // given
            given(
                musicApiService.fetchArtistFromServer(artistName = artistName)
            ).willReturn(expectedResult)

            // When
            val actualNavigationCommand =
                classUnderTest.getArtistListFromApi(artistName = artistName)

            // Then
            assertEquals(expectedResult, actualNavigationCommand)
        }

    @Test
    fun `given expectedResult When fetchArtistAlbumFromServer Then return expected result`() =
        runBlocking {

            val expectedResult = aristAlbumApiModelOutputResult
            // given
            given(
                musicApiService.fetchArtistAlbumFromServer(artistId = artistId)
            ).willReturn(expectedResult)

            // When
            val actualNavigationCommand =
                classUnderTest.getArtistAlbumFromServer(artistId = artistId)

            // Then
            assertEquals(expectedResult, actualNavigationCommand)
        }
}