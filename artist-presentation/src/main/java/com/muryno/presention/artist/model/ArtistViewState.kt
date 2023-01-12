package com.muryno.presention.artist.model

data class ArtistViewState(
    val isLoading: Boolean = false,
    val artist: List<ArtistPresentationModel>? = null
) {
    fun loading() = copy(isLoading = true)

    fun artistReady(
        artist: List<ArtistPresentationModel>
    ) = copy(artist = artist, isLoading = false)
}
