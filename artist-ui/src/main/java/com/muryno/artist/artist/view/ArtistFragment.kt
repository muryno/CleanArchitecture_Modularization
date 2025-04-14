package com.muryno.artist.artist.view

import com.muryno.artist.artist.theme.AppTheme
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.muryno.artist.artist.mapper.ArtistPresentationToUIMapper
import com.muryno.artist.base.BaseFragment
import com.muryno.presention.artist.model.ArtistViewState
import com.muryno.presention.artist.viewmodel.ArtistViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistFragment : BaseFragment<ArtistViewState>() {
    override val viewModel: ArtistViewModel by viewModels()

    @Inject
    lateinit var artistToUiMapper: ArtistPresentationToUIMapper

    // No need for layoutResourceId since we're using Compose
    override val layoutResourceId = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    ArtistScreen(
                        viewModel = viewModel,
                        artistToUiMapper = artistToUiMapper
                    )
                }
            }
        }
    }

    // This is a dummy implementation since we don't need to bind views with Compose
    override fun View.bindViews() {
        // No-op - we don't need to bind views with Compose
    }
}
