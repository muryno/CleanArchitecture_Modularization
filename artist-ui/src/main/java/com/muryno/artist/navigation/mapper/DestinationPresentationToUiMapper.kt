package com.muryno.artist.navigation.mapper

import com.muryno.artist.navigation.model.UiDestination
import com.muryno.presention.architecture.model.PresentationDestination

interface DestinationPresentationToUiMapper {
    fun toUi(input: PresentationDestination): UiDestination
}
