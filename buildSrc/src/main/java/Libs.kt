/**
 * Centralized library dependency coordinates for the project.
 * This object contains Maven coordinates for all libraries used in the application,
 * referencing versions from [BuildDepVersions] where applicable.
 */
object Libs {
    /** Reference to version constants */
    private val v = BuildDepVersions

    //Circle Imageview
    //-----------------------------------------------------------------------------------------------------
    /** Circle ImageView library for displaying circular images */
    const val CircleImage = "de.hdodenhof:circleimageview:3.1.0"

    //Glide
    //-----------------------------------------------------------------------------------------------------
    /** Glide image loading and caching library */
    const val GLIDE = "com.github.bumptech.glide:glide:4.12.0"
    
    /** Glide annotation processor for code generation */
    const val Glidekapt = "com.github.bumptech.glide:compiler:4.12.0"

    //lottie
    //-----------------------------------------------------------------------------------------------------
    /** Lottie animation library for rendering Adobe After Effects animations */
    const val Lottie = "com.airbnb.android:lottie:5.2.0"

    //shimmer
    //-----------------------------------------------------------------------------------------------------
    /** Facebook Shimmer effect library for loading placeholders */
    const val Shimmer = "com.facebook.shimmer:shimmer:0.5.0"

    //Android Component
    //-----------------------------------------------------------------------------------------------------
    /** AndroidX AppCompat library for backward compatibility */
    const val AppCompat = "androidx.appcompat:appcompat:1.5.1"
    
    /** AndroidX Core KTX library with Kotlin extensions */
    const val Core = "androidx.core:core-ktx:1.9.0"
    
    /** AndroidX RecyclerView for displaying scrollable lists */
    const val RecyclerView = "androidx.recyclerview:recyclerview:1.2.1"
    
    /** ConstraintLayout for building responsive UI layouts */
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    
    /** Fragment KTX library with Kotlin extensions */
    const val fragment = "androidx.fragment:fragment-ktx:1.5.3"

    //GOOGLE Material design
    //-----------------------------------------------------------------------------------------------------
    /** Material Design Components library */
    const val MaterialDesign = "com.google.android.material:material:1.6.1"

    //SWIPE REFRESH
    //-----------------------------------------------------------------------------------------------------
    /** SwipeRefreshLayout for pull-to-refresh functionality */
    const val swiperefreshlayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

    //-----------------------------------------------------------------------------------------------------
    //KTX
    /** LiveData KTX with Kotlin coroutine support */
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
    
    /** Lifecycle runtime KTX library */
    const val LIFECYCLE_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    
    /** ViewModel KTX with Kotlin extensions */
    const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
    
    /** Lifecycle common Java 8 support */
    const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:2.5.1"
    
    /** Lifecycle annotation processor */
    const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:2.5.1"


    //-----------------------------------------------------------------------------------------------------
    //RETROFIT
    /** Retrofit REST client library */
    const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
    
    /** Retrofit Gson converter for JSON serialization */
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:2.9.0"

    //-----------------------------------------------------------------------------------------------------
    //OKHTTP
    /** OkHttp HTTP client library */
    const val OKHTTP = "com.squareup.okhttp3:okhttp:4.9.3"
    
    /** OkHttp logging interceptor for debugging */
    const val OKHTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:4.9.3"
    
    /** OkHttp URL connection support */
    const val OKHTTP_urlconnection = "com.squareup.okhttp3:okhttp-urlconnection:4.9.3"

    //-----------------------------------------------------------------------------------------------------
    //GSON
    /** Gson library for JSON parsing and serialization */
    const val GSON = "com.google.code.gson:gson:${v.GSON}"

    //-----------------------------------------------------------------------------------------------------
    //HILT
    /** Hilt dependency injection framework */
    const val HILT = "com.google.dagger:hilt-android:2.51.1"
    
    /** Hilt annotation processor */
    const val HILT_COMPILER = "com.google.dagger:hilt-compiler:2.51.1"
    
    /** Hilt navigation integration for Jetpack Compose */
    const val HILT_COMPOSE_NAV = "androidx.hilt:hilt-navigation-compose:${v.HILT_COMPOSE}"


    //-----------------------------------------------------------------------------------------------------
    //ROOM DATABASE
    /** Room database runtime library */
    const val ROOM = "androidx.room:room-runtime:2.4.3"
    
    /** Room annotation processor */
    const val ROOM_COMPILER_Kap = "androidx.room:room-compiler:2.4.3"
    
    /** Room KTX with Kotlin coroutine support */
    const val ROOMKTX = "androidx.room:room-ktx:2.4.3"
    
    /** Room testing utilities */
    const val ROOM_TESTING = "androidx.room:room-testing:2.4.3"

    //-----------------------------------------------------------------------------------------------------
    //NAVIGATION
    /** Navigation Fragment KTX for fragment navigation */
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:2.7.7"
    
    /** Navigation UI KTX for UI components integration */
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:2.7.7"


    //JETPACK COMPOSE
    //-----------------------------------------------------------------------------------------------------
    /** Compose UI core library */
    const val COMPOSE_UI = "androidx.compose.ui:ui:${v.COMPOSE}"
    
    /** Material Design components for Compose */
    const val MATERIAL_COMPOSE = "androidx.compose.material:material:${v.COMPOSE}"
    
    /** Compose UI tooling for previews */
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${v.COMPOSE}"
    
    /** Compose UI tooling preview annotations */
    const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${v.COMPOSE}"
    
    /** Activity Compose integration */
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${v.COMPOSE_ACTIVITY}"
    
    /** Navigation component for Compose */
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${v.COMPOSE}"
    
    /** Accompanist navigation animation library */
    const val COMPOSE_NAV_ANIM =
        "com.google.accompanist:accompanist-navigation-animation:${v.COMPOSE_NAV_ANIM}"
        
    /** Compose runtime library */
    const val COMPOSE_RUNTIME = "androidx.compose.runtime:runtime:${v.COMPOSE_COMPILER}"
    
    /** Material 3 Design components for Compose */
    const val COMPOSE_MATERIAL_3 = "androidx.compose.material3:material3-android:${v.COMPOSE_MATERIAL_3}"
    
    /** LiveData integration for Compose */
    const val COMPOSE_LIVE_DATA = "androidx.compose.runtime:runtime-livedata:${v.COMPOSE_LIVEDATA}"
    
    /** Compose UI tooling preview for Android */
    const val COMPOSE_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview-android:${v.COMPOSE_PREVIEW}"


    //-----------------------------------------------------------------------------------------------------
    //KOTLIN COROUTINES
    /** Kotlin Coroutines core library */
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${v.COROUTINES}"
    
    /** Kotlin Coroutines Android integration */
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${v.COROUTINES}"


}



















