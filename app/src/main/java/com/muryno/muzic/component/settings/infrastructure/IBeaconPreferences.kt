package com.muryno.muzic.component.settings.infrastructure

import com.kylecorry.trail_sense.tools.beacons.infrastructure.sort.BeaconSortMethod

interface IBeaconPreferences {
    val showLastSignalBeacon: Boolean
    var beaconSort: BeaconSortMethod
}