package com.muryno.artist_datasource.mapper

import com.muryno.artist_datasource.model.ArtistApiModel
import com.muryno.data.model.ArtistDataModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class ArtistApiToResponseDataMapperTest(
    private val givenArtistApiModel: ArtistApiModel,
    private val expectedArtistDataModel: ArtistDataModel
) {
    companion object {
        @JvmStatic
        @Parameters
        fun data(): Collection<Array<*>> = listOf(
            testCase(
                gender = "female",
                disambiguation = "What's so special about it?",
                title = "Chop Chop",
                id = "1"
            ),
            testCase(
                gender = "male",
                disambiguation = "Delightful.",
                title = "Al Akel",
                id = "2"
            )
        )

        private fun testCase(
            gender: String,
            disambiguation: String,
            title: String,
            id: String
        ) = arrayOf(
            ArtistApiModel(
                aliases = emptyList(),
                area = null,
                beginArea = null,
                disambiguation = disambiguation,
                gender = gender,
                genderId = "1",
                id = id,
                ipis = emptyList(),
                isnis = emptyList(),
                lifeSpan = null,
                name = title,
                score = 20,
                sort_name = "nambia",
                tags = emptyList(),
                type = "",
                type_id = "1"
            ),
            ArtistDataModel(
                id = id,
                name = title,
                gender = gender,
                type = "",
                state = "",
                disambiguation = disambiguation,
                score = 20
            )
        )
    }

    private lateinit var classUnderTest: ArtistApiToResponseDataMapper

    @Before
    fun setUp() {
        classUnderTest = ArtistApiToResponseDataMapper()
    }

    @Test
    fun `Given Data ArtistApiModel when toData then returns expected Domain ArtistDataModel`() {
        // When
        val actualValue = classUnderTest.toData(givenArtistApiModel)

        // Then
        assertEquals(expectedArtistDataModel, actualValue)
    }
}
