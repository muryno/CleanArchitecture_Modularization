package com.muryno.muzic.component.settings.infrastructure

import com.kylecorry.trail_sense.shared.ErrorBannerReason

interface IErrorPreferences {

    fun canShowError(error: ErrorBannerReason): Boolean
    fun setCanShowError(error: ErrorBannerReason, canShow: Boolean)

}