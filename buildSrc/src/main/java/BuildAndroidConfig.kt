/**
 * Configuration object containing Android build settings and application identifiers.
 * This object centralizes all build configuration constants used across the multi-module project.
 */
object BuildAndroidConfig {

    /**
     * Main application ID for the app module
     */
    const val APPLICATION_ID = "com.muryno.muzic"

    /**
     * Package identifier for the data layer module
     */
    const val APPLICATION_DATA = "com.muryno.data"
    
    /**
     * Package identifier for the domain layer module
     */
    const val APPLICATION_DOMAIN = "com.muryno.domain"
    
    /**
     * Package identifier for the presentation layer module
     */
    const val APPLICATION_PRESENTATION = "com.muryno.presentation"


    /**
     * Package identifier for the artist UI module
     */
    const val APPLICATION_ARTIST_UI = "com.muryno.artist"

    /**
     * Android SDK version to compile against
     */
    const val COMPILE_SDK_VERSION = 34
    
    /**
     * Minimum Android SDK version supported by the app
     */
    const val MIN_SDK_VERSION = 21
    
    /**
     * Target Android SDK version for the app
     */
    const val TARGET_SDK_VERSION = 34

    /**
     * Version code for the application (used for versioning in Play Store)
     */
    const val VERSION_CODE = 1
    
    /**
     * Version name for the application (user-visible version string)
     */
    const val VERSION_NAME = "1.0"

    /**
     * Test runner class for Android instrumented tests
     */
    const val ANDROID_JUNIT_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    
    /**
     * JVM bytecode target version
     */
    const val JVM_TARGET = "1.8"

}