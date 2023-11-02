package com.muryno.muzic.component.diagnostics.status

import com.muryno.muzic.component.diagnostics.status.StatusBadge

interface StatusBadgeProvider {
    fun getBadge(): StatusBadge
}