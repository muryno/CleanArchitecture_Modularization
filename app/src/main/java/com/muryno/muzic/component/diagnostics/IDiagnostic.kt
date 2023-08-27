package com.kylecorry.trail_sense.diagnostics

import com.muryno.muzic.component.diagnostics.DiagnosticCode

interface IDiagnostic {
    fun scan(): List<DiagnosticCode>
}