package com.muryno.domain

import com.muryno.domain.artist.repository.ArtistRepository
import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel
import com.muryno.domain.artistAlbulm.usecase.ArtistAlbumUserUseCaseExecutor
import com.muryno.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

const val artistId = "Wizkid"

@RunWith(MockitoJUnitRunner::class)
class ArtistAlbumUseCaseTest {

    @Mock private lateinit var coroutineContextProvider: CoroutineContextProvider

    private lateinit var classUnderTest: ArtistAlbumUserUseCaseExecutor

    @Mock private lateinit var artistRepository: ArtistRepository

    @Before
    fun setup() {

        classUnderTest =
                ArtistAlbumUserUseCaseExecutor(
                        artistRepository = artistRepository,
                        coroutineContextProvider
                )
    }

    @Test
    fun `When actualResult Then return  expectedResult Response`() {
        runBlocking {
            val expectedResult =
                    arrayListOf(
                            ArtistAlbumDomainModel(
                                    disambiguation = "abc",
                                    id = "123",
                                    genre = "afro",
                                    label = "sony",
                                    shortDescription = "good things",
                                    fullDescription = "good things come to everyone",
                                    primaryType = "music",
                                    title = "asder",
                                    releaseDate = "23-2-2022"
                            )
                    )

            // Given
            given(artistRepository.artistAlbum(artistId = artistId)).willReturn(expectedResult)

            // When
            val actualResult = classUnderTest.executeInBackground(request = artistId)

            // Then
            assertEquals(expectedResult, actualResult)
        }
    }
}
