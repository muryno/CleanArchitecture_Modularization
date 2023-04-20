plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_JETBRAINS)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION
        multiDexEnabled = true

    }

    namespace = BuildAndroidConfig.APPLICATION_DOMAIN
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

    //CORE --------------------------------------------------------------------------------------
    implementation(Libs.Core)

    //RETROFIT, OKHTTP & GSON ----------------------------------------------------------------------------------------
    implementation(Libs.RETROFIT)
    implementation(Libs.GSON)
    implementation(Libs.RETROFIT_CONVERTER_GSON)
    implementation(Libs.OKHTTP)
    implementation(Libs.OKHTTP_urlconnection)

    //COROUTINES  ----------------------------------------------------------------------------------------
    implementation(Libs.COROUTINES_CORE)

    //ROOM ----------------------------------------------------------------------------------------
    implementation(Libs.ROOM)
    kapt(Libs.ROOM_COMPILER_Kap)
    implementation(Libs.ROOMKTX)


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