package com.muryno.artist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.muryno.artist.R
import com.muryno.artist.adapter.ArtistAlbumAdapter
import com.muryno.presention.viewmodel.ArtistAlbumViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistDetailsFragment : Fragment() {

    private val viewModel by viewModels<ArtistAlbumViewModel>()


    @Inject
    lateinit var adapter: ArtistAlbumAdapter
    //private val args: DetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.artist_fragment_details, container, false)
    }

}


