package com.muryno.artist.artist.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.muryno.artist.R
import com.muryno.artist.architecture.mapper.ViewStateBinder
import com.muryno.artist.architecture.view.BaseFragment
import com.muryno.artist.architecture.view.ViewsProvider
import com.muryno.artist.artist.binder.ArtistViewStateBinder
import com.muryno.artist.artist.model.ArtistUIModel
import com.muryno.artist.navigation.mapper.DestinationPresentationToUiMapper
import com.muryno.presention.artist.model.ArtistViewState
import com.muryno.presention.artist.viewmodel.ArtistViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistFragment : BaseFragment<ArtistViewState>(),
    ArtistViewsProvider, ArtistViewStateBinder.OnClickListener{

    override val viewModel: ArtistViewModel by viewModels()



    override lateinit var destinationMapper: DestinationPresentationToUiMapper

    @Inject
    @JvmSuppressWildcards
    override lateinit var viewStateBinder: ViewStateBinder<ArtistViewState, ViewsProvider>
    override val layoutResourceId = R.layout.artist_fragment_home
    override lateinit var artistListView: RecyclerView
    override lateinit var progressBar: ProgressBar
    override lateinit var searchButton: Button
    override lateinit var musicSearch: EditText
    override lateinit var emptyState: View

    override fun View.bindViews() {
        artistListView = findViewById(R.id.artist_recyclerView)
        progressBar = findViewById(R.id.artist_progressbar)
        searchButton = findViewById(R.id.search_button)
        musicSearch = findViewById(R.id.music_search)
        emptyState = findViewById(R.id.empty_state)
    }

    private val artist = "London"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.onEntered(artist)
        }
    }

    override fun onArtistClick(artist: ArtistUIModel) {
        val action = ArtistFragmentDirections.actionArtistFragmentToArtistDetailsFragment(artist)
        view?.findNavController()?.navigate(action)
    }

    override fun onArtistButtonClick() {
        closeSoftKeyboard()
        viewModel.onEntered(artistName = musicSearch.text.toString())
    }

}