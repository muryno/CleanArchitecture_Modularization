package com.muryno.muzic.di

import androidx.fragment.app.Fragment
import com.muryno.artist.architecture.mapper.ViewStateBinder
import com.muryno.artist.architecture.view.ViewsProvider
import com.muryno.artist.artist.binder.ArtistViewStateBinder
import com.muryno.artist.artist.mapper.ArtistPresentationToUIMapper
import com.muryno.artist.artist.view.ArtistFragment
import com.muryno.presention.artist.model.ArtistViewState
import com.muryno.presention.artistAlbulm.mapper.ArtistAlbumDomainToPresentationMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class ArtistUiModule {

    @Provides
    @Suppress("UNCHECKED_CAST")
    fun providesRestaurantDetailsViewStateBinder(
        fragment: Fragment,
        dishPresentationToUiMapper: ArtistPresentationToUIMapper
    ) = ArtistViewStateBinder(
        fragment as ArtistFragment,
        dishPresentationToUiMapper
    ) as ViewStateBinder<ArtistViewState, ViewsProvider>

    @Provides
    fun providesArtistPresentationToUIMapper() =
        ArtistPresentationToUIMapper()


}
