package com.muryno.presention.artistAlbum.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel
import com.muryno.domain.artistAlbulm.usecase.ArtistAlbumUserUseCase
import com.muryno.domain.cleanarchitecture.usecase.UseCaseExecutor
import com.muryno.presention.artistAlbulm.mapper.ArtistAlbumDomainToPresentationMapper
import com.muryno.presention.artistAlbulm.model.ArtistAlbumPresentationModel
import com.muryno.presention.artistAlbulm.model.ArtistAlbumViewState
import com.muryno.presention.artistAlbulm.viewmodel.ArtistAlbumViewModel
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
class ArtistAlbumViewModelTest {

    private lateinit var classUnderTest: ArtistAlbumViewModel


    @Mock
    private lateinit var getArtistAlbumUseCase: ArtistAlbumUserUseCase


    @Mock
    private lateinit var artistAlbumDomainMapper: ArtistAlbumDomainToPresentationMapper


    @get:Rule
    val instantTaskExecutorRule: TestRule =
        InstantTaskExecutorRule()

    @Mock
    private lateinit var useCaseExecutor: UseCaseExecutor

    @Before
    fun setup() {
        classUnderTest = ArtistAlbumViewModel(
            getArtistAlbumUseCase,
            artistAlbumDomainMapper
        ) { useCaseExecutor }
    }

    @Test
    fun `Given no action when view state observed then presents default state`() {
        // Given
        val expectedViewStates =
            listOf(ArtistAlbumViewState())

        val actualViewStates = mutableListOf<ArtistAlbumViewState>()

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

        val givenDish1 =  ArtistAlbumDomainModel(
            id = dishId,
            title = name,
            disambiguation = disambiguation,
            primaryType = type,
            releaseDate = state
        )
        val givenDish2 =  ArtistAlbumDomainModel(
            id = dishId,
            title = name,
            disambiguation = disambiguation,
            primaryType = type,
            releaseDate = state
        )

        val givenDishes = arrayListOf(givenDish1, givenDish2)

        val expectedDish1 =    ArtistAlbumPresentationModel(
            id = dishId,
            title = name,
            disambiguation = disambiguation,
            primaryType = type,
            releaseDate = state
        )
        given(artistAlbumDomainMapper.toPresentation(givenDish1)).willReturn(expectedDish1)
        val expectedDish2 =   ArtistAlbumPresentationModel(
            id = dishId,
            title = name,
            disambiguation = disambiguation,
            primaryType = type,
            releaseDate = state
        )
        given(artistAlbumDomainMapper.toPresentation(givenDish2)).willReturn(expectedDish2)
        val expectedDishes = listOf(expectedDish1, expectedDish2)

        useCaseExecutor.givenUseCaseSuccess(getArtistAlbumUseCase, restaurantId, givenDishes)

        val expectedViewStates = listOf(
            ArtistAlbumViewState(isLoading = true),
            ArtistAlbumViewState(artistAlbum = expectedDishes)
        )

        val actualViewStates = classUnderTest.observeViewStateForever()
        actualViewStates.clear()

        // When
        classUnderTest.fetchArtistAlbum(restaurantId)

        // Then
        assertEquals(expectedViewStates, actualViewStates)
    }


}