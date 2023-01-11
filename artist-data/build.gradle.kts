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
        testInstrumentationRunner = "com.muryno.trendinggithubuser.HiltTestRunner"

    }

    namespace = BuildAndroidConfig.APPLICATION_DATA


}

dependencies {

    implementation(project(BuildModules.DOMAIN))

    //CORE --------------------------------------------------------------------------------------
    implementation(Libs.Core)


    //COROUTINES  ----------------------------------------------------------------------------------------
    implementation(Libs.COROUTINES_CORE)



    //TESTING
    testImplementation(TestLibs.JUNIT)
    testImplementation(TestLibs.CORE_TEST)
    testImplementation(TestLibs.MOCKITO_INLINE)
    testImplementation(TestLibs.MOKITO_KOTLIN)
    testImplementation(TestLibs.MOCKK)
    testImplementation(TestLibs.kOTLINX_COUROUTINE)
    testImplementation(TestLibs.kOTLINX_COUROUTINE_TEST)


}