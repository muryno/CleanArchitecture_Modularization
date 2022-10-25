package com.muryno.presention.mapper



import com.muryno.domain.model.ArtistDomainModel
import com.muryno.presention.model.ArtistModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

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

@RunWith(Parameterized::class)
class ArtistListApiDataToDomainMapperTest(
    private val input: ArtistDomainModel,
    private val expectedOutput: ArtistModel
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun getParameters() = listOf(
            arrayOf(artistDomainModel, artistPresentationModel),
        )
    }

    private lateinit var classUnderTest: ArtistDomainToPresentationMapper

    @Before
    fun setup() {
        classUnderTest = ArtistDomainToPresentationMapper()
    }

    @Test
    fun `Given ArtistDomainModel  When toPresentation Then returns expectedOutput `() {

        // When
        val actualOutput = classUnderTest.toPresentation(input)
        // Then
        assertEquals(expectedOutput, actualOutput)
    }

}