package com.muryno.data.model

data class ArtistListApiModel(
    val artistApiModels: List<ArtistApiModel>,
    val count: Int,
    val created: String,
    val offset: Int
)