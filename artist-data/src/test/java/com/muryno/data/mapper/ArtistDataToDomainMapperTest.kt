package com.muryno.data.mapper

import com.muryno.data.model.ArtistDataModel
import com.muryno.domain.artist.model.ArtistDomainModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.MethodRule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.junit.MockitoJUnit

@RunWith(Parameterized::class)
class ArtistDataToDomainMapperTest(
    private val givenArtist: ArtistDataModel,
    private val expectedArtist: ArtistDomainModel
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<*>> = listOf(
            testCase(
                state = "321",
                type = "Sunday Special",
                disambiguation = "What's so special about it?",
                name = "Chop Chop",
                id = "1",
                gender = "male"
            ),
            testCase(
                state = "123",
                type = "Night Delight",
                disambiguation = "Delightful.",
                name = "Al Akel",
                id = "2",
                gender = "female"
            )
        )

        private fun testCase(
            state: String,
            type: String,
            disambiguation: String,
            name: String,
            id: String,
            gender: String
        ) = arrayOf(
            ArtistDataModel(
                id = id,
                name = name,
                type = type,
                state = state,
                score = 1,
                gender = gender,
                disambiguation = disambiguation
            ),
            ArtistDomainModel(
                id = id,
                name = name,
                type = type,
                state = state,
                score = 1,
                gender = gender,
                disambiguation = disambiguation
            ),
        )
    }

    @get:Rule
    val mockitoRule: MethodRule = MockitoJUnit.rule()

    private lateinit var classUnderTest: ArtistDataToDomainMapper


    @Before
    fun setUp() {
        classUnderTest = ArtistDataToDomainMapper()
    }

    @Test
    fun `Given ArtistApiModel model When toDomain Then returns ArtistDomainModel data model`() {

        // When
        val actualOutput = classUnderTest.toDomain(givenArtist)
        // Then
        assertEquals(expectedArtist, actualOutput)
    }

}