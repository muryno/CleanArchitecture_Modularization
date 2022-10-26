package com.muryno.data.mapper


import com.muryno.data.model.Area
import com.muryno.data.model.ArtistApiModel
import com.muryno.domain.model.ArtistDomainModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

val artistModelInput = ArtistApiModel(
    disambiguation = "ader",
    id = "123",
    area = Area(
        id = "123",
        life_span = null,
        name = "artist",
        sort_name = "wizzy",
        type = "wizzy",
        type_id = "234"
    ),
    gender = "male",
    type_id = "",
    type = "",
    tags = emptyList(),
    sort_name = "",
    score = 1,
    name = "artist",
    life_span = null,
    isnis = emptyList(),
    ipis = emptyList(),
    gender_id = "",
    begin_area = null,
    aliases = emptyList()
)

val artistDomainExpectedOutput = ArtistDomainModel(
    disambiguation = "ader",
    id = "123",
    name = "artist",
    type = "wizzy",
    state = "artist",
    score = 1,
    gender = "male"
)


@RunWith(Parameterized::class)
class ArtistListApiDataToDomainMapperTest(
    private val input: ArtistApiModel,
    private val expectedOutput: ArtistDomainModel
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun getParameters() = listOf(
            arrayOf(artistModelInput, artistDomainExpectedOutput),
        )
    }

    private lateinit var classUnderTest: ArtistApiDataToDomainMapper

    @Before
    fun setup() {
        classUnderTest = ArtistApiDataToDomainMapper()
    }

    @Test
    fun `Given ArtistApiModel model When toDomain Then returns ArtistDomainModel data model`() {

        // When
        val actualOutput = classUnderTest.toDomain(input)
        // Then
        assertEquals(expectedOutput, actualOutput)
    }

}