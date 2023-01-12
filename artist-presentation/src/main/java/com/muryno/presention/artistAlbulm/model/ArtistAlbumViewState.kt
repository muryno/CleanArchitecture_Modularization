package com.muryno.presention.artistAlbulm.model

data class ArtistAlbumViewState(
    val isLoading: Boolean = false,
    val artistAlbum: List<ArtistAlbumPresentationModel>? = null
) {
    fun loading() = copy(isLoading = true)

    fun artistAlbumReady(
        artistAlbum: List<ArtistAlbumPresentationModel>
    ) = copy(artistAlbum = artistAlbum, isLoading = false)
}
