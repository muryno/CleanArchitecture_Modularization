package com.muryno.artist_datasource.mapper

import com.muryno.artist_datasource.model.album.AlbumReleaseGroupApiModel
import com.muryno.data.model.ArtistAlbumDataModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.MethodRule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import org.mockito.junit.MockitoJUnit

@RunWith(Parameterized::class)
class ArtistAlbumApiToResponseDataMapperTest(
        private val givenArtistAlbum: AlbumReleaseGroupApiModel,
        private val expectedArtistAlbum: ArtistAlbumDataModel
) {
    companion object {
        @JvmStatic
        @Parameters
        fun data(): Collection<Array<*>> =
                listOf(
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
        ) =
                arrayOf(
                        AlbumReleaseGroupApiModel(
                                disambiguation = disambiguation,
                                firstReleaseDate = firstReleaseDate,
                                id = id,
                                primaryType = primaryType,
                                primaryTypeId = "",
                                secondaryTypeIds = emptyList(),
                                secondaryTypes = emptyList(),
                                title = title
                        ),
                        ArtistAlbumDataModel(
                                id = id,
                                title = title,
                                releaseDate = firstReleaseDate,
                                disambiguation = disambiguation,
                                primaryType = primaryType
                        )
                )
    }

    @get:Rule val mockitoRule: MethodRule = MockitoJUnit.rule()

    private lateinit var classUnderTest: ArtistAlbumApiToResponseDataMapper

    @Before
    fun setUp() {
        classUnderTest = ArtistAlbumApiToResponseDataMapper()
    }

    @Test
    fun `Given Data dish when toDomain then returns expected Domain dish`() {

        // When
        val actualValue = classUnderTest.toData(givenArtistAlbum)

        // Then
        assertEquals(expectedArtistAlbum, actualValue)
    }
}
