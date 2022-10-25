package com.muryno.presention.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.muryno.domain.model.ArtistDomainModel
import com.muryno.presention.model.ArtistModel
import com.muryno.domain.usecase.ArtistUseCase
import com.muryno.presention.mapper.ArtistDomainToPresentationMapper
import com.muryno.presention.utils.TestCoroutineRule
import com.muryno.presention.utils.getOrAwaitValue
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
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

private val artistPresentationModel = ArtistModel(
    description = "ader",
    id = "123",
    name = "artist",
    city = "wizzy",
    state = "artist",
    score = 1,
    gender = "male"
)

const val ArtistName =  "wizzy"

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ArtistViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var classUnderTest: ArtistViewModel

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()


    @Mock
    private lateinit var artistUseCase: ArtistUseCase


    @Mock
    private lateinit var artistDomainMapper: ArtistDomainToPresentationMapper


    @Before
    fun setup() {
        classUnderTest = ArtistViewModel(
            artistUseCase = artistUseCase,
            artistDomainMapper = artistDomainMapper
        )
    }


    @Test
    fun `given artistUseCase when artistQuery Then return expected result`() {
        testCoroutineRule.runBlockingTest  {
            val artistDomainExpectedResult = listOf(artistDomainModel)

            val expectedResult = listOf(artistPresentationModel)
            // Given
            given(
                artistUseCase.execute(ArtistName)
            ).willReturn(
                artistDomainExpectedResult
            )

            given(
                artistDomainMapper.toPresentation(artistDomainModel)
            ).willReturn(
                artistPresentationModel
            )

            classUnderTest.artistQuery(ArtistName)

            val actualResult = classUnderTest.artistState.getOrAwaitValue()

            assertEquals(expectedResult, actualResult)
        }

    }




}