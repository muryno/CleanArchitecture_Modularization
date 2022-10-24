package com.muryno.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.muryno.domain.model.ArtistAlbumDomainModel
import com.muryno.domain.repository.ArtistRepository
import com.muryno.domain.usecase.ArtistAlbumUserUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

private val artistDomainModel = ArtistAlbumDomainModel(
    disambiguation = "abc",
    id = "123",
    primaryType = "music",
    title = "asder",
    releaseDate = "23-2-2022"
)

const val artistId = "Wizkid"

@RunWith(MockitoJUnitRunner::class)
class ArtistAlbumUseCaseTest {


    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var classUnderTest: ArtistAlbumUserUseCase

    @Mock
    private lateinit var artistRepository: ArtistRepository

    @Before
    fun setup() {
        classUnderTest = ArtistAlbumUserUseCase(
            artistRepository = artistRepository,
        )
    }


    @Test
    fun `When actualResult Then return  expectedResult Response`() {
        runBlocking {
            val expectedResult = arrayListOf(artistDomainModel)
            // Given
            given(
                artistRepository.artistAlbum(artistId = artistId, type = "" )
            ).willReturn(
                expectedResult
            )

            // When
            val actualResult = classUnderTest.execute(artistId = artistId, type = "")

            // Then
            assertEquals(expectedResult, actualResult)
        }
    }

}