package com.muryno.presention.mapper



import com.muryno.domain.model.ArtistAlbumDomainModel
import com.muryno.domain.model.ArtistDomainModel
import com.muryno.presention.model.ArtistAlbumModel
import com.muryno.presention.model.ArtistModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

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


@RunWith(Parameterized::class)
class ArtistAlbumDomainToPresentationMapperTest(
    private val input: ArtistAlbumDomainModel,
    private val expectedOutput: ArtistAlbumModel
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun getParameters() = listOf(
            arrayOf(artistAlbumDomainModel, artistAlbumPresentationModel),
        )
    }

    private lateinit var classUnderTest: ArtistAlbumDomainToPresentationMapper

    @Before
    fun setup() {
        classUnderTest = ArtistAlbumDomainToPresentationMapper()
    }

    @Test
    fun `Given ArtistAlbumDomainModel  When toPresentation Then returns expectedOutput `() {

        // When
        val actualOutput = classUnderTest.toPresentation(input)
        // Then
        assertEquals(expectedOutput, actualOutput)
    }

}