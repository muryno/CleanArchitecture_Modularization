package com.muryno.muzic.component.diagnostics

import android.content.Context
import com.kylecorry.andromeda.permissions.Permissions
import com.kylecorry.andromeda.permissions.SpecialPermission
import com.kylecorry.trail_sense.diagnostics.DiagnosticCode
import com.kylecorry.trail_sense.diagnostics.IDiagnostic

class AlarmDiagnostic(private val context: Context) : IDiagnostic {
    override fun scan(): List<DiagnosticCode> {
        if (!Permissions.hasPermission(context, SpecialPermission.SCHEDULE_EXACT_ALARMS)) {
            return listOf(DiagnosticCode.ExactAlarmNoPermission)
        }

        return emptyList()
    }
}