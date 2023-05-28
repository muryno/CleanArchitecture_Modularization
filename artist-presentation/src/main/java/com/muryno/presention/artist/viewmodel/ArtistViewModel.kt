package com.muryno.presention.artist.viewmodel

import com.muryno.domain.artist.model.ArtistDomainModel
import com.muryno.domain.artist.usecase.ArtistUseCaseExecutor
import com.muryno.presention.architecture.viewmodel.BaseViewModel
import com.muryno.presention.architecture.viewmodel.usecase.UseCaseExecutorProvider
import com.muryno.presention.artist.mapper.ArtistDomainToPresentationMapper
import com.muryno.presention.artist.model.ArtistViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private typealias DoNothing = Unit

@HiltViewModel
class ArtistViewModel @Inject constructor(
    private val artistUseCase: ArtistUseCaseExecutor,
    private val artistDomainMapper: ArtistDomainToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
) : BaseViewModel<ArtistViewState>(
    useCaseExecutorProvider
) {
    override fun initialState() = ArtistViewState()

    fun onEntered(artistName: String) {
        updateViewState(ArtistViewState::loading)
        execute(
            artistUseCase,
            artistName,
            onSuccess = { artist -> presentDishDetails(artist) },
            onException = { DoNothing }
        )
    }

    private fun presentDishDetails(artist: List<ArtistDomainModel>) {
        updateViewState { artistReady(artist.map (artistDomainMapper::toPresentation )) }
    }

}





