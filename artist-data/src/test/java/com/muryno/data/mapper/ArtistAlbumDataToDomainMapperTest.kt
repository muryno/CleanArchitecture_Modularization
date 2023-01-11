package com.muryno.data.mapper


import com.muryno.data.model.ArtistAlbumDataModel
import com.muryno.domain.model.ArtistAlbumDomainModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.MethodRule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.junit.MockitoJUnit


@RunWith(Parameterized::class)
class ArtistAlbumDataToDomainMapperTest(
    private val givenArtistAlbum: ArtistAlbumDataModel,
    private val expectedArtistAlbum: ArtistAlbumDomainModel
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<*>> = listOf(
            testCase(
                primaryType = "321",
                firstReleaseDate = "Sunday Special",
                disambiguation = "What's so special about it?",
                title = "Chop Chop",
                id = "1"
            ),
            testCase(
                primaryType = "123",
                firstReleaseDate = "Night Delight",
                disambiguation = "Delightful.",
                title = "Al Akel",
                id = "2"
            )
        )

        private fun testCase(
            primaryType: String,
            firstReleaseDate: String,
            disambiguation: String,
            title: String,
            id: String
        ) = arrayOf(
            ArtistAlbumDataModel(
                id = id,
                title =  title,
                releaseDate = firstReleaseDate,
                disambiguation = disambiguation,
                primaryType = primaryType
            ),
            ArtistAlbumDomainModel(
                id = id,
                title =  title,
                releaseDate = firstReleaseDate,
                disambiguation = disambiguation,
                primaryType = primaryType
            ),
        )
    }

    @get:Rule
    val mockitoRule: MethodRule = MockitoJUnit.rule()

    private lateinit var classUnderTest: ArtistAlbumDataToDomainMapper


    @Before
    fun setUp() {
        classUnderTest = ArtistAlbumDataToDomainMapper()
    }

    @Test
    fun `Given AlbumReleaseGroupApiModel model When toDomain Then returns ArtistAlbumDomainModel data model`() {

        // When
        val actualOutput = classUnderTest.toDomain(givenArtistAlbum)
        // Then
        assertEquals(expectedArtistAlbum, actualOutput)
    }

}