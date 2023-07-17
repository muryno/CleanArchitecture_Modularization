package com.muryno.muzic.component.diagnostics

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import com.kylecorry.andromeda.permissions.Permissions
import com.kylecorry.trail_sense.diagnostics.DiagnosticCode
import com.kylecorry.trail_sense.diagnostics.IDiagnostic

class CameraDiagnostic(private val context: Context) : IDiagnostic {

    @SuppressLint("UnsupportedChromeOsCameraSystemFeature")
    override fun scan(): List<DiagnosticCode> {
        val issues = mutableListOf<DiagnosticCode>()

        if (!Permissions.isCameraEnabled(context)) {
            issues.add(DiagnosticCode.CameraNoPermission)
        }

        if (!context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            issues.add(DiagnosticCode.CameraUnavailable)
        }

        return issues
    }
}