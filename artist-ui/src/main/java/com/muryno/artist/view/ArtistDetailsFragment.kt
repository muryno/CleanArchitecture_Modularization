package com.muryno.artist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.muryno.artist.R
import com.muryno.artist.adapter.ArtistAlbumAdapter
import com.muryno.presention.artist.model.ArtistPresentationModel
import com.muryno.presention.artistAlbulm.viewmodel.ArtistAlbumViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistDetailsFragment : Fragment() {

    @Inject
    lateinit var adapter: ArtistAlbumAdapter

    private val viewModel by viewModels<ArtistAlbumViewModel>()

    private val args: ArtistDetailsFragmentArgs by navArgs()

    private val recyclerView: RecyclerView get() = requireView().findViewById(R.id.artist_details_recyclerView)

    private val progressbar: ProgressBar get() = requireView().findViewById(R.id.artist__details_progressbar)

    private val emptyState: View get() = requireView().findViewById(R.id.empty_state)

    private val backBtn: View get() = requireView().findViewById(R.id.back_btn)

    private val artistNameTextView: TextView get() = requireView().findViewById(R.id.artist_name)

    private val artistCityTextView: TextView get() = requireView().findViewById(R.id.artist_city_txt)

    private val scoreTextView: TextView get() = requireView().findViewById(R.id.score_txt)

    private val artistDescription: TextView get() = requireView().findViewById(R.id.artist_description)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.artist_fragment_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter

        viewModel.artistAlbumState.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                adapter.differ.submitList(it)
                emptyState.visibility = View.GONE
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
                progressbar.visibility = View.VISIBLE
                recyclerView.visibility = View.INVISIBLE
            } else {
                progressbar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE

            }
        }

        view(args.artistModel)

        backBtn.setOnClickListener {
            val nav = ArtistDetailsFragmentDirections.actionArtistDetailsFragmentToArtistFragment()
            view.findNavController().navigate(nav)
        }

    }

    private fun view(artistPresentationModel: ArtistPresentationModel) {
        artistNameTextView.text = artistPresentationModel.name
        artistCityTextView.text = artistPresentationModel.city
        scoreTextView.text = artistPresentationModel.score.toString()
        artistDescription.text = artistPresentationModel.description
        viewModel.artistAlbumQuery(artistId = artistPresentationModel.id)
    }
}


