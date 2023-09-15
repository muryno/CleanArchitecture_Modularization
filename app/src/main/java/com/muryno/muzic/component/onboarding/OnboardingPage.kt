package com.muryno.muzic.component.onboarding

import androidx.annotation.DrawableRes

data class OnboardingPage(
    val title: String,
    val contents: CharSequence,
    @DrawableRes val image: Int,
    val nextButtonText: String? = null,
)
