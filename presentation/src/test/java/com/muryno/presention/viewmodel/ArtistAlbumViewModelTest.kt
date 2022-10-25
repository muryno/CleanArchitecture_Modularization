package com.muryno.presention.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.muryno.domain.model.ArtistAlbumDomainModel
import com.muryno.domain.usecase.ArtistAlbumUserUseCase
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

    @Before
    fun setup() {
        classUnderTest = ArtistAlbumViewModel(
            artistAlbumUseCase = artistAlbumUseCase
        )
    }


    @Test
    fun `given artistAlbumUseCase when artistAlbumQuery Then return expected result`() {
        testCoroutineRule.runBlockingTest {
            val expectedResult = listOf(artistAlbumDomainModel)
            // Given
            given(
                artistAlbumUseCase.execute(artistId = artistID, type = "")
            ).willReturn(
                expectedResult
            )

            classUnderTest.artistAlbumQuery(artistId = artistID, type = "")

            val actualResult = classUnderTest.artistAlbumState.getOrAwaitValue()

            assertEquals(expectedResult, actualResult)
        }

    }


}