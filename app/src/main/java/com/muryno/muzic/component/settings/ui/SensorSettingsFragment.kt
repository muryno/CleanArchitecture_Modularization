package com.muryno.muzic.component.settings.ui

import android.os.Bundle
import com.kylecorry.andromeda.core.system.Resources
import com.kylecorry.andromeda.fragments.AndromedaPreferenceFragment
import com.kylecorry.andromeda.sense.Sensors
import com.kylecorry.trail_sense.R
import com.muryno.muzic.component.settings.ui.navigateOnClick

class SensorSettingsFragment : AndromedaPreferenceFragment() {

    private val navigationMap = mapOf(
        R.string.pref_sensor_details to R.id.sensorDetailsFragment,
        R.string.pref_cell_signal_settings to R.id.cellSignalSettingsFragment,
        R.string.pref_compass_sensor to R.id.calibrateCompassFragment,
        R.string.pref_altimeter_calibration to R.id.calibrateAltimeterFragment,
        R.string.pref_gps_calibration to R.id.calibrateGPSFragment,
        R.string.pref_barometer_calibration to R.id.calibrateBarometerFragment,
        R.string.pref_temperature_settings to R.id.thermometerSettingsFragment,
        R.string.pref_camera_settings to R.id.cameraSettingsFragment
    )

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.sensor_preferences, rootKey)

        setIconColor(Resources.androidTextColorSecondary(requireContext()))

        for (nav in navigationMap) {
            navigateOnClick(preference(nav.key), nav.value)
        }

        preference(R.string.pref_barometer_calibration)?.isVisible = Sensors.hasBarometer(requireContext())
    }

}