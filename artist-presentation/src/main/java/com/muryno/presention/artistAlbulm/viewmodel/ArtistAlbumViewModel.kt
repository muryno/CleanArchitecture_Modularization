package com.muryno.presention.artistAlbulm.viewmodel

import com.muryno.domain.artistAlbulm.model.ArtistAlbumDomainModel
import com.muryno.domain.artistAlbulm.usecase.ArtistAlbumUserUseCaseExecutor
import com.muryno.presention.architecture.viewmodel.BaseViewModel
import com.muryno.presention.architecture.viewmodel.usecase.UseCaseExecutorProvider
import com.muryno.presention.artistAlbulm.mapper.ArtistAlbumDomainToPresentationMapper
import com.muryno.presention.artistAlbulm.model.ArtistAlbumViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArtistAlbumViewModel @Inject constructor(
    private val artistAlbumUseCase: ArtistAlbumUserUseCaseExecutor,
    private val artistAlbumDomainMapper: ArtistAlbumDomainToPresentationMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
) : BaseViewModel<ArtistAlbumViewState>(
    useCaseExecutorProvider
) {
    override fun initialState() = ArtistAlbumViewState()

    fun fetchArtistAlbum(artistName: String) {
        updateViewState(ArtistAlbumViewState::loading)
        execute(artistAlbumUseCase, artistName, ::presentArtistAlbum)
    }

    private fun presentArtistAlbum(artist: List<ArtistAlbumDomainModel>) {
        val artistList = artist.map {
            artistAlbumDomainMapper
                .toPresentation(it)
        }
        updateViewState { artistAlbumReady(artistList) }
    }

}





