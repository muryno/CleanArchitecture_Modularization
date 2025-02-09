plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_JETBRAINS)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.DAGGER_HILT)
    id(BuildPlugins.NAV_GRAPH)

}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION
        multiDexEnabled = true

    }
    namespace = BuildAndroidConfig.APPLICATION_ARTIST_UI

    buildFeatures {
        viewBinding = true
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = BuildAndroidConfig.JVM_TARGET
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(project(BuildModules.PRESENTATION))

    //CORE --------------------------------------------------------------------------------------
    implementation(Libs.Core)
    implementation(Libs.RecyclerView)
    implementation(Libs.constraintlayout)
    implementation(Libs.fragment)
    implementation(Libs.MaterialDesign)
    implementation(Libs.AppCompat)

    implementation(Libs.NAVIGATION_FRAGMENT)
    implementation(Libs.NAVIGATION_UI)

    //RETROFIT, OKHTTP & GSON ----------------------------------------------------------------------------------------
    implementation(Libs.RETROFIT)
    implementation(Libs.GSON)
    implementation(Libs.RETROFIT_CONVERTER_GSON)
    implementation(Libs.OKHTTP)
    implementation(Libs.OKHTTP_LOGGING)
    implementation(Libs.OKHTTP_urlconnection)


    //COROUTINES  ----------------------------------------------------------------------------------------
    implementation(Libs.COROUTINES_CORE)

    //ROOM ----------------------------------------------------------------------------------------
    implementation(Libs.ROOM)
    kapt(Libs.ROOM_COMPILER_Kap)
    implementation(Libs.ROOMKTX)

    //HILT----------------------------------------------------------------------------------------

    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt ("com.google.dagger:hilt-compiler:2.51.1")

}