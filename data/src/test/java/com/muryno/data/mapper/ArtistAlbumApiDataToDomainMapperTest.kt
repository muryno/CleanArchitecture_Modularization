package com.muryno.data.mapper


import com.muryno.data.model.album.AlbumReleaseGroupApiModel
import com.muryno.domain.model.ArtistAlbumDomainModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

val input = AlbumReleaseGroupApiModel(
    disambiguation = "abc",
    firstReleaseDate = "23-2-2022",
    id = "123",
    primaryType = "music",
    primaryTypeId = "",
    secondaryTypeIds = emptyList(),
    secondaryTypes = emptyList(),
    title = "asder"
)

val expectedOutput = ArtistAlbumDomainModel(
    disambiguation = "abc",
    id = "123",
    primaryType = "music",
    title = "asder",
    releaseDate = "23-2-2022"
)


@RunWith(Parameterized::class)
class ArtistAlbumApiDataToDomainMapperTest(
    private val input: AlbumReleaseGroupApiModel,
    private val expectedOutput: ArtistAlbumDomainModel
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun getParameters() = listOf(
            arrayOf(input, expectedOutput),
        )
    }


    private lateinit var classUnderTest: ArtistAlbumApiDataToDomainMapper

    @Before
    fun setup() {
        classUnderTest = ArtistAlbumApiDataToDomainMapper()
    }

    @Test
    fun `Given AlbumReleaseGroupApiModel model When toDomain Then returns ArtistAlbumDomainModel data model`() {

        // When
        val actualOutput = classUnderTest.toDomain(input)
        // Then
        assertEquals(expectedOutput, actualOutput)
    }

}