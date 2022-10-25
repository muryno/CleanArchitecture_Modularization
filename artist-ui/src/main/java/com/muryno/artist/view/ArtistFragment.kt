package com.muryno.artist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.muryno.artist.R
import com.muryno.artist.adapter.ArtistAdapter
import com.muryno.artist.adapter.ArtistAlbumAdapter
import com.muryno.presention.viewmodel.ArtistViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistFragment : Fragment() {

    private val viewModel by viewModels<ArtistViewModel>()

    private val artistRecycler: RecyclerView get() = requireView().findViewById(R.id.artist_recyclerView)

    private val progressBar: ProgressBar get() = requireView().findViewById(R.id.artist_progressbar)

    private val searchButton: Button get() = requireView().findViewById(R.id.search_button)

    private val musicSearch: Button get() = requireView().findViewById(R.id.music_search)


    private val emptyState: View get() = requireView().findViewById(R.id.empty_state)

    private val artist = "wizkid"

    @Inject
    lateinit var adapter: ArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.artist_fragment_home, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.artistQuery(artistName = artist)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        artistRecycler.adapter = adapter

        searchButton.setOnClickListener {
            viewModel.artistQuery(artistName =  musicSearch.text.toString())
        }

        viewModel.artistState.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                adapter.differ.submitList(it)
            }
        }


        viewModel.errorState.observe(viewLifecycleOwner) {
            if (it) {
                emptyState.visibility = View.VISIBLE
            } else {
                emptyState.visibility = View.GONE
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it) {
                emptyState.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }

        }
    }




}