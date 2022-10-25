package com.muryno.muzic

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: App? = null
            private set
    }
}