package com.muryno.presention.artist.model

data class ArtistViewState(
    val isLoading: Boolean = false,
    val artist: List<ArtistPresentationModel>? = null
) {
    fun isLoading() = copy(isLoading = true)

    fun isArtistReady(
        artist: List<ArtistPresentationModel>
    ) = copy(artist = artist, isLoading = false)
}
