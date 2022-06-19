package com.muryno.presention.artist.mapper


import com.muryno.domain.artist.model.ArtistDomainModel
import com.muryno.presention.artist.model.ArtistPresentationModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.MethodRule
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.junit.MockitoJUnit

@RunWith(Parameterized::class)
class ArtistListApiDataToDomainMapperTest(
    private val input: ArtistDomainModel,
    private val expectedOutput: ArtistPresentationModel
) {
    companion object {
        private const val DISH_ID_1 = "ID1"
        private const val DISH_NAME_1 = "Piri Piri Chicken"
        private const val DISH_COMMENT_1 = "Great spicing."
        private const val DISH_RATING_1 = ""
        private const val RESTAURANT_NAME_1 = ""
        private const val COUNTRY_NAME = ""
        private const val DISH_ID_2 = "ID2"
        private const val DISH_NAME_2 = "Cauliflower Steak"
        private const val DISH_COMMENT_2 = "So dry."
        private const val DISH_RATING_2 = ""
        private const val RESTAURANT_NAME_2 = ""

        @JvmStatic
        @Parameterized.Parameters(name = "Given {0} then returns {1}")
        fun data(): Iterable<Array<Any>> = listOf(
            testCase(
                disambiguation = DISH_ID_1,
                id = DISH_NAME_1,
                gender = DISH_COMMENT_1,
                name = DISH_RATING_1,
                city = RESTAURANT_NAME_1,
                state = RESTAURANT_NAME_1,
                score = 1
                country = COUNTRY_NAME
            ),
            testCase(
                disambiguation = DISH_ID_2,
                id = DISH_NAME_2,
                gender = DISH_COMMENT_2,
                name = DISH_RATING_2,
                city = RESTAURANT_NAME_2,
                state = RESTAURANT_NAME_2,
                score = 1
            )
        )

        private fun testCase(
            disambiguation: String,
            id: String,
            gender: String,
            name: String,
            city: String,
            state: String,
            country: String,
            score: Int
        ) = arrayOf(
            ArtistDomainModel(
                disambiguation = disambiguation,
                id = id,
                name = name,
                type = city,
                state = state,
                score = 1,
                country = country,
                gender = gender
            ),
            ArtistPresentationModel(
                description = disambiguation,
                id = id,
                name = name,
                city = city,
                state = state,
                country = country,
                score =score,
                gender = gender
            )
        )
    }

    @get:Rule
    val mockitoRule: MethodRule = MockitoJUnit.rule()

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