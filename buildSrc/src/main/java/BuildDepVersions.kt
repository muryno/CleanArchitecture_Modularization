/**
 * Centralized version management object for all project dependencies.
 * This object defines version numbers for libraries used throughout the application
 * to maintain consistency and easy version updates.
 */
object BuildDepVersions {

    //-----------------------------------------------------------------------------------------------------
    //CORE
    /** AndroidX Core KTX version */
    const val CORE_KTX = "1.7.0"
    
    /** AndroidX AppCompat version */
    const val CORE_APP = "7.1.2"
    
    /** Kotlin Standard Library JDK version */
    const val KOTLIN_STDLIB_JDK = "1.6.10"
    
    /** Kotlin language version */
    const val KOTLIN = "1.6.10"

    //-----------------------------------------------------------------------------------------------------
    //TEST LIBS
    /** JUnit testing framework version */
    const val JUNIT = "4.13.2"
    
    /** AndroidX JUnit extension version */
    const val JUNIT_EXT_ANDROID = "1.1.3"
    
    /** Espresso UI testing framework version */
    const val EXPRESSO = "3.4.0"

    //-----------------------------------------------------------------------------------------------------
    //JETPACK COMPOSE
    /** Jetpack Compose UI toolkit version */
    const val COMPOSE = "1.1.1"
    
    /** Compose compiler version */
    const val COMPOSE_COMPILER = "1.5.1"
    
    /** Compose Activity integration version */
    const val COMPOSE_ACTIVITY = "1.3.1"
    
    /** Accompanist navigation animation version */
    const val COMPOSE_NAV_ANIM = "0.24.8-beta"
    
    /** Material 3 Design for Compose version */
    const val COMPOSE_MATERIAL_3 = "1.3.1"
    
    /** Compose LiveData integration version */
    const val COMPOSE_LIVEDATA = "1.7.8"
    
    /** Compose UI tooling preview version */
    const val COMPOSE_PREVIEW = "1.7.8"

    //COIL (IMAGE LOADING)
    /** Accompanist Coil integration version */
    const val COIL_ACCOMPANIST = "0.15.0"
    
    /** Coil image loading library version */
    const val COIL = "2.1.0"

    //PAGING
    /** Jetpack Paging library version */
    const val PAGING = "1.0.0-alpha14"

    //-----------------------------------------------------------------------------------------------------
    //KTX
    /** AndroidX Lifecycle components version */
    const val LIFECYCLE = "2.3.1"
    
    /** AndroidX Lifecycle extensions version */
    const val LIFECYCLE_EXTS = "2.2.0"

    //-----------------------------------------------------------------------------------------------------
    //KOTLIN COROUTINES
    /** Kotlin Coroutines library version */
    const val COROUTINES = "1.3.9"

    //-----------------------------------------------------------------------------------------------------
    //STORE (local + network cache)
    /** Dropbox Store library version for caching */
    const val STORE_DROPBOX = "4.0.5"

    //-----------------------------------------------------------------------------------------------------
    //HILT
    /** Hilt dependency injection framework version */
    const val HILT = "2.38.1"
    
    /** Hilt Compose integration version */
    const val HILT_COMPOSE = "1.0.0"

    //-----------------------------------------------------------------------------------------------------
    //RETROFIT & OKHTTP & GSON
    /** Retrofit REST client version */
    const val RETROFIT = "2.9.0"
    
    /** OkHttp HTTP client version */
    const val OKHTTP = "4.9.3"
    
    /** Gson JSON serialization library version */
    const val GSON = "2.9.0"

    //-----------------------------------------------------------------------------------------------------
    //MULTIDEX
    /** Multidex support library version */
    const val MULTIDEX = "1.0.3"

    //-----------------------------------------------------------------------------------------------------
    //ROOM
    /** Room database library version */
    const val ROOM = "2.4.2"

    //-----------------------------------------------------------------------------------------------------
    //MAP STRUCT
    /** MapStruct object mapping library version */
    const val MAP_STRUCT = "1.5.0.RC1"


}