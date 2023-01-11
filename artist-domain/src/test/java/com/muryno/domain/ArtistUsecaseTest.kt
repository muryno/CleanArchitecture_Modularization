package com.muryno.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.muryno.domain.model.ArtistDomainModel
import com.muryno.domain.repository.ArtistRepository
import com.muryno.domain.usecase.ArtistUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
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
class ArtistUsecaseTest {


    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var classUnderTest: ArtistUseCase

    @Mock
    private lateinit var artistRepository: ArtistRepository

    @Before
    fun setup() {
        classUnderTest = ArtistUseCase(
            artistRepository = artistRepository,
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
            val actualResult = classUnderTest.execute(artistName = artistName)

            // Then
            assertEquals(expectedResult, actualResult)
        }
    }


}