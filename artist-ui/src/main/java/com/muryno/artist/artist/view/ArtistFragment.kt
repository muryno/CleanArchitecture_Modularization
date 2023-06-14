package com.muryno.artist.artist.view

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.muryno.artist.R
import com.muryno.artist.artist.adapter.ArtistAdapter
import com.muryno.artist.artist.mapper.ArtistPresentationToUIMapper
import com.muryno.artist.base.BaseFragment
import com.muryno.presention.artist.model.ArtistViewState
import com.muryno.presention.artist.viewmodel.ArtistViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistFragment : BaseFragment<ArtistViewState>(){

    override val viewModel: ArtistViewModel by viewModels()



    @Inject
    lateinit var artistToUiMapper: ArtistPresentationToUIMapper

    override val layoutResourceId = R.layout.artist_fragment_home
     lateinit var artistListView: RecyclerView
     lateinit var progressBar: ProgressBar
     lateinit var searchButton: Button
     lateinit var musicSearch: EditText
     lateinit var emptyState: View

    override fun View.bindViews() {
        artistListView = findViewById(R.id.artist_recyclerView)
        progressBar = findViewById(R.id.artist_progressbar)
        searchButton = findViewById(R.id.search_button)
        musicSearch = findViewById(R.id.music_search)
        emptyState = findViewById(R.id.empty_state)
    }

    private val artist = "London"

    private val artistAdapter by lazy {
        ArtistAdapter().apply {
            clickedArtist = {
                closeSoftKeyboard()
                viewModel.onEntered(artistName = musicSearch.text.toString())
            }
        }
    }


    override fun onResume() {
        super.onResume()
        viewModel.viewState.observe(viewLifecycleOwner){viewState->
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

            searchButton.setOnClickListener {
                closeSoftKeyboard()
                viewModel.onEntered(artistName = musicSearch.text.toString())
            }

        }
        viewModel.onEntered(artist)
    }


}