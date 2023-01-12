package com.muryno.presention.artistAlbum.mapper


import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel
import com.muryno.presention.artistAlbulm.mapper.ArtistAlbumDomainToPresentationMapper
import com.muryno.presention.artistAlbulm.model.ArtistAlbumPresentationModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.MethodRule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.junit.MockitoJUnit

@RunWith(Parameterized::class)
class ArtistAlbumDomainToPresentationMapperTest(
    private val input: ArtistAlbumDomainModel,
    private val expectedOutput: ArtistAlbumPresentationModel
) {
    companion object {
        private const val DISH_ID_1 = "ID1"
        private const val DISH_NAME_1 = "Piri Piri Chicken"
        private const val DISH_COMMENT_1 = "Great spicing."
        private const val DISH_RATING_1 = ""
        private const val RESTAURANT_NAME_1 = "City Chicken"
        private const val DISH_ID_2 = "ID2"
        private const val DISH_NAME_2 = "Cauliflower Steak"
        private const val DISH_COMMENT_2 = "So dry."
        private const val DISH_RATING_2 = ""
        private const val RESTAURANT_NAME_2 = "Vegan Fever"

        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} then returns {1}")
        fun data(): Iterable<Array<Any>> = listOf(
            testCase(
                disambiguation = DISH_ID_1,
                id = DISH_NAME_1,
                primaryType = DISH_COMMENT_1,
                title = DISH_RATING_1,
                releaseDate = RESTAURANT_NAME_1
            ),
            testCase(
                disambiguation = DISH_ID_2,
                id = DISH_NAME_2,
                primaryType = DISH_COMMENT_2,
                title = DISH_RATING_2,
                releaseDate = RESTAURANT_NAME_2
            )
        )

        private fun testCase(
            disambiguation: String,
            id: String,
            primaryType: String,
            title: String,
            releaseDate: String
        ) = arrayOf(
            ArtistAlbumDomainModel(
                disambiguation = disambiguation,
                id = id,
                primaryType = primaryType,
                title = title,
                releaseDate = releaseDate
            ),
            ArtistAlbumPresentationModel(
                disambiguation = disambiguation,
                id = id,
                primaryType = primaryType,
                title = title,
                releaseDate = releaseDate
            )
        )
    }

    @get:Rule
    val mockitoRule: MethodRule = MockitoJUnit.rule()

    private lateinit var classUnderTest: ArtistAlbumDomainToPresentationMapper

    @Before
    fun setup() {
        classUnderTest = ArtistAlbumDomainToPresentationMapper()
    }

    @Test
    fun `When toPresentation`() {

        // When
        val actualOutput = classUnderTest.toPresentation(input)
        // Then
        assertEquals(expectedOutput, actualOutput)
    }

}