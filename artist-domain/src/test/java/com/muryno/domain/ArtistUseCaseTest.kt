package com.muryno.domain

import com.muryno.domain.artist.model.ArtistDomainModel
import com.muryno.domain.artist.repository.ArtistRepository
import com.muryno.domain.artist.usecase.ArtistUseCaseExecutor
import com.muryno.domain.cleanarchitecture.coroutine.CoroutineContextProvider
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

private val artistDomainModel = ArtistDomainModel(
    disambiguation = "ader",
    id = "123",
    name = "artist",
    type = "wizzy",
    state = "artist",
    score = 1,
    gender = "male"
)

const val artistName = "Wizkid"

@RunWith(MockitoJUnitRunner::class)
class ArtistUseCaseTest {


    private lateinit var classUnderTest: ArtistUseCaseExecutor

    @Mock
    private lateinit var coroutineContextProvider: CoroutineContextProvider

    @Mock
    private lateinit var artistRepository: ArtistRepository

    @Before
    fun setup() {

        classUnderTest = ArtistUseCaseExecutor(
            artistRepository = artistRepository,
            coroutineContextProvider
        )
    }


    @Test
    fun `When actualResult Then return  expectedResult Response`() {
        runBlocking {
            val expectedResult = arrayListOf(artistDomainModel)
            // Given
            given(
                artistRepository.artistList(artistName = artistName)
            ).willReturn(
                expectedResult
            )

            // When
            val actualResult = classUnderTest.executeInBackground(request = artistName)

            // Then
            assertEquals(expectedResult, actualResult)
        }
    }


}