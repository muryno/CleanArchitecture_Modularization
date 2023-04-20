plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_JETBRAINS)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.DAGGER_HILT)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION
        multiDexEnabled = true

    }

    namespace = BuildAndroidConfig.APPLICATION_PRESENTATION
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(project(BuildModules.DOMAIN))

    //CORE --------------------------------------------------------------------------------------
    implementation(Libs.Core)

    //VIEW MODEL ----------------------------------------------------------------------------------------
    implementation(Libs.VIEWMODEL_KTX)
    implementation(Libs.LIFECYCLE_COMPILER)
    implementation(Libs.LIFECYCLE_LIVEDATA)


    //COROUTINES  ----------------------------------------------------------------------------------------
    implementation(Libs.COROUTINES_CORE)

    //ROOM ----------------------------------------------------------------------------------------
    implementation(Libs.ROOM)
    kapt(Libs.ROOM_COMPILER_Kap)
    implementation(Libs.ROOMKTX)

    //HILT----------------------------------------------------------------------------------------
//    implementation(Libs.HILT)
//    kapt(Libs.HILT_COMPILER)
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt ("com.google.dagger:hilt-compiler:2.51.1")

    //TESTING
    testImplementation(TestLibs.JUNIT)
    testImplementation(TestLibs.CORE_TEST)
    testImplementation(TestLibs.MOCKITO_INLINE)
    testImplementation(TestLibs.MOKITO_KOTLIN)
    testImplementation(TestLibs.MOCKK)
    testImplementation(TestLibs.IOMOCKK_ANDROID)
    testImplementation(TestLibs.IOMOCKK_ANDROID)
    testImplementation(TestLibs.TEST_RUNNER)
    testImplementation(TestLibs.TEST_RUNNER_EXT)
    testImplementation(TestLibs.TEST_RUNNER_ANDROID)
    testImplementation(TestLibs.EXPRESSO_TEST)
    testImplementation(TestLibs.TEST_RULE)

    testImplementation(TestLibs.MOCKWEBSERVER)
    testImplementation(TestLibs.kOTLINX_COUROUTINE)
    testImplementation(TestLibs.kOTLINX_COUROUTINE_TEST)
    kaptAndroidTest(TestLibs.HILT_ANDROID_COMPILER)

    //ANDROID TEST-----------------------------------------------------------------------------------------

    androidTestImplementation(TestLibs.JUNIT_ANDROID)
    androidTestImplementation(TestLibs.TEST_RUNNER_ANDROID)
    androidTestImplementation(TestLibs.kOTLINX_COUROUTINE_ANDROID)
    androidTestImplementation(TestLibs.CoreTesting_ANDROID)
    androidTestImplementation(TestLibs.Hilt_ANDROID)
    androidTestImplementation(TestLibs.Truth_ANDROID)


}