package com.muryno.muzic.component.settings.infrastructure

import com.kylecorry.trail_sense.tools.maps.domain.sort.MapSortMethod

interface IMapPreferences {
    val autoReduceMaps: Boolean
    val showMapPreviews: Boolean
    var mapSort: MapSortMethod
    val keepMapFacingUp: Boolean
}