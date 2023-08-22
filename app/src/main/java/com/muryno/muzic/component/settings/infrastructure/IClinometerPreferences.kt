package com.muryno.muzic.component.settings.infrastructure

import com.kylecorry.sol.units.Distance

interface IClinometerPreferences {
    var lockWithVolumeButtons: Boolean
    var baselineDistance: Distance?
}