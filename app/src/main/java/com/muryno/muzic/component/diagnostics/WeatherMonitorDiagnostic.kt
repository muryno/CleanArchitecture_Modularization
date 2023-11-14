package com.muryno.muzic.component.diagnostics

import android.content.Context
import com.kylecorry.andromeda.sense.Sensors
import com.kylecorry.trail_sense.diagnostics.IDiagnostic
import com.kylecorry.trail_sense.shared.UserPreferences

class WeatherMonitorDiagnostic(private val context: Context) : IDiagnostic {

    private val prefs = UserPreferences(context)

    override fun scan(): List<DiagnosticCode> {
        if (Sensors.hasBarometer(context)) {
            val isRunning =
                prefs.weather.shouldMonitorWeather && !(prefs.isLowPowerModeOn && prefs.lowPowerModeDisablesWeather)
            if (!isRunning) {
                return listOf(DiagnosticCode.WeatherMonitorDisabled)
            }
        }
        return emptyList()
    }
}