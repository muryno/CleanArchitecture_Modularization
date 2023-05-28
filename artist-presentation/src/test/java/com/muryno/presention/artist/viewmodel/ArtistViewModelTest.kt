package com.muryno.presention.artist.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.muryno.domain.artist.model.ArtistDomainModel
import com.muryno.domain.artist.usecase.ArtistUseCaseExecutor
import com.muryno.domain.cleanarchitecture.usecase.UseCaseExecutor
import com.muryno.presention.artist.mapper.ArtistDomainToPresentationMapper
import com.muryno.presention.artist.model.ArtistPresentationModel
import com.muryno.presention.artist.model.ArtistViewState
import com.muryno.presention.viewmodel.givenUseCaseSuccess
import com.muryno.presention.viewmodel.observeViewStateForever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner




@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ArtistViewModelTest {

    @get:Rule
    val instantTaskExecutorRule: TestRule =
        InstantTaskExecutorRule()


    private lateinit var classUnderTest: ArtistViewModel

    @Mock
    private lateinit var getArtistUseCase: ArtistUseCaseExecutor

    @Mock
    private lateinit var artistDomainMapper: ArtistDomainToPresentationMapper


    @Mock
    private lateinit var useCaseExecutor: UseCaseExecutor

    @Before
    fun setup() {
        classUnderTest = ArtistViewModel(
            artistUseCase = getArtistUseCase,
            artistDomainMapper = artistDomainMapper
        ) { useCaseExecutor }
    }

    @Test
    fun `Given no action when view state observed then presents default state`() {
        // Given
        val expectedViewStates =
            listOf(ArtistViewState())

        val actualViewStates = mutableListOf<ArtistViewState>()

        // When
        classUnderTest.viewState.observeForever(actualViewStates::add)

        // Then
        assertEquals(expectedViewStates, actualViewStates)
    }


    @Test
    fun `Given restaurantId, dishes when onEntered then presents loading, dish list`() {
        // Given
        val restaurantId = "REST007"
        val artistName = "wizzy"
        val dishId = "dishId"

        val name = "Spaghetti Pomadoro"
        val score = 5
        val disambiguation = "Perfecto"
        val state = "artist"
        val type = "type"
        val gender = "male"

        val givenDish1 = ArtistDomainModel(
            id = dishId,
            name = name,
            disambiguation = disambiguation,
            type = type,
            state = state,
            score = score,
            gender = gender
        )
        val givenDish2 = ArtistDomainModel(
            id = dishId,
            name = name,
            disambiguation = disambiguation,
            type = type,
            state = state,
            score = score,
            gender = gender
        )

        val givenDishes = arrayListOf(givenDish1, givenDish2)

        val expectedDish1 =  ArtistPresentationModel(
            id = dishId,
            name = name,
            description = disambiguation,
            city = type,
            state = state,
            score = score,
            gender = gender
        )
        given(artistDomainMapper.toPresentation(givenDish1)).willReturn(expectedDish1)
        val expectedDish2 = ArtistPresentationModel(
            id = dishId,
            name = name,
            description = disambiguation,
            city = type,
            state = state,
            score = score,
            gender = gender
        )
        given(artistDomainMapper.toPresentation(givenDish2)).willReturn(expectedDish2)
        val expectedDishes = listOf(expectedDish1, expectedDish2)

        useCaseExecutor.givenUseCaseSuccess(getArtistUseCase, restaurantId, givenDishes)

        val expectedViewStates = listOf(
            ArtistViewState(isLoading = true),
            ArtistViewState(artist = expectedDishes)
        )

        val actualViewStates = classUnderTest.observeViewStateForever()
        actualViewStates.clear()

        // When
        classUnderTest.onEntered(restaurantId)

        // Then
        assertEquals(expectedViewStates, actualViewStates)
    }

}