package com.muryno.presention.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.muryno.domain.model.ArtistAlbumDomainModel
import com.muryno.domain.usecase.ArtistAlbumUserUseCase
import com.muryno.presention.mapper.ArtistAlbumDomainToPresentationMapper
import com.muryno.presention.model.ArtistAlbumModel
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


private val artistAlbumDomainModel = ArtistAlbumDomainModel(
    disambiguation = "abc",
    id = "123",
    primaryType = "music",
    title = "asder",
    releaseDate = "23-2-2022"
)

private val artistAlbumPresentationModel = ArtistAlbumModel(
    disambiguation = "abc",
    id = "123",
    primaryType = "music",
    title = "asder",
    releaseDate = "23-2-2022"
)

private const val artistID = "123"

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ArtistAlbumViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var classUnderTest: ArtistAlbumViewModel


    @Mock
    private lateinit var artistAlbumUseCase: ArtistAlbumUserUseCase


    @Mock
    private lateinit var artistAlbumDomainMapper: ArtistAlbumDomainToPresentationMapper

    @Before
    fun setup() {
        classUnderTest = ArtistAlbumViewModel(
            artistAlbumUseCase = artistAlbumUseCase,
            artistAlbumDomainMapper
        )
    }


    @Test
    fun `given artistAlbumUseCase when artistAlbumQuery Then return expected result`() {
        testCoroutineRule.runBlockingTest {
            val artistAlbumDomainModelExpectedResult = listOf(artistAlbumDomainModel)

            val expectedResult = listOf(artistAlbumPresentationModel)

            // Given
            given(
                artistAlbumUseCase.execute(artistId = artistID)
            ).willReturn(
                artistAlbumDomainModelExpectedResult
            )

            given(
                artistAlbumDomainMapper.toPresentation(artistAlbumDomainModel)
            ).willReturn(
                artistAlbumPresentationModel
            )

            classUnderTest.artistAlbumQuery(artistId = artistID)

            val actualResult = classUnderTest.artistAlbumState.getOrAwaitValue()

            assertEquals(expectedResult, actualResult)
        }

    }


}