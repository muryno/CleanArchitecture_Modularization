package com.muryno.muzic.component.settings.infrastructure

import com.muryno.muzic.component.settings.infrastructure.CameraPreferences

interface ICameraPreferences {
    val useZeroShutterLag: Boolean
    val projectionType: CameraPreferences.ProjectionType
}