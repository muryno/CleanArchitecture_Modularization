package com.muryno.artist.artist.binder

import android.view.View
import com.muryno.artist.architecture.mapper.ViewStateBinder
import com.muryno.artist.artist.adapter.ArtistAdapter
import com.muryno.artist.artist.mapper.ArtistPresentationToUIMapper
import com.muryno.artist.artist.model.ArtistUIModel
import com.muryno.artist.artist.view.ArtistViewsProvider
import com.muryno.presention.artist.model.ArtistViewState


class ArtistViewStateBinder(
    private val onArtistClickListener: OnClickListener,
    private val artistToUiMapper: ArtistPresentationToUIMapper
) : ViewStateBinder<ArtistViewState, ArtistViewsProvider> {
    private val artistAdapter by lazy {
        ArtistAdapter().apply {
            clickedArtist = {
                onArtistClickListener.onArtistClick(it)
            }
        }
    }

    override fun ArtistViewsProvider.bindState(viewState: ArtistViewState) {
        if (artistListView.adapter == null) {
            artistListView.adapter = artistAdapter
        }

        if (viewState.isLoading) {
            emptyState.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
            artistListView.visibility = View.INVISIBLE
        } else {
            progressBar.visibility = View.GONE
            artistListView.visibility = View.VISIBLE
            artistAdapter.differ.submitList(viewState.artist?.map(artistToUiMapper::toUi))
        }

        searchButton.setOnClickListener { onArtistClickListener.onArtistButtonClick() }

    }
    //            if (it) {
//                emptyState.visibility = View.VISIBLE
//
//            } else {
//                emptyState.visibility = View.GONE
//            }
//        }



    interface OnClickListener {
        fun onArtistClick(artist: ArtistUIModel)
        fun  onArtistButtonClick()
    }
}
