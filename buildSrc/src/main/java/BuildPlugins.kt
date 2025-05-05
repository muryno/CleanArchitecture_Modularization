/**
 * Gradle plugin identifiers used across the project build configuration.
 * This object centralizes plugin references for consistent application throughout modules.
 */
object BuildPlugins {

    //-----------------------------------------------------------------------------------------------------
    //ANDROID
    /** Gradle plugin for Android application modules */
    const val ANDROID_APPLICATION = "com.android.application"
    
    /** Gradle plugin for Android library modules */
    const val ANDROID_LIBRARY = "com.android.library"

    //-----------------------------------------------------------------------------------------------------
    //KOTLIN
    /** Kotlin annotation processing tool plugin */
    const val KAPT = "kapt"
    
    /** Kotlin KAPT plugin (full identifier) */
    const val KOTLIN_KAPT = "kotlin-kapt"
    
    /** Kotlin Android plugin (short identifier) */
    const val KOTLIN_ANDROID = "kotlin-android"
    
    /** Kotlin Android plugin from JetBrains (full identifier) */
    const val KOTLIN_ANDROID_JETBRAINS = "org.jetbrains.kotlin.android"

    //-----------------------------------------------------------------------------------------------------
    //HILT
    /** Dagger Hilt dependency injection plugin for Android */
    const val DAGGER_HILT = "com.google.dagger.hilt.android"

    //Nav
    /** AndroidX Navigation Safe Args plugin for type-safe navigation */
    const val NAV_GRAPH = "androidx.navigation.safeargs.kotlin"

}