package com.muryno.muzic.component.settings.infrastructure

interface ITidePreferences {
    val showNearestTide: Boolean
    var lastTide: Long?
}