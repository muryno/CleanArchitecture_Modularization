plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID_JETBRAINS)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    namespace = "com.muryno.artist_datasource"
    compileSdk = 32

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(BuildModules.DATA))

    //CORE --------------------------------------------------------------------------------------
    implementation(Libs.Core)
    //COROUTINES  ----------------------------------------------------------------------------------------
    implementation(Libs.COROUTINES_CORE)

    //RETROFIT, OKHTTP & GSON ----------------------------------------------------------------------------------------
    implementation(Libs.RETROFIT)
    implementation(Libs.GSON)
    implementation(Libs.RETROFIT_CONVERTER_GSON)
    implementation(Libs.OKHTTP)
    implementation(Libs.OKHTTP_urlconnection)

    testImplementation(TestLibs.JUNIT)
    testImplementation(TestLibs.CORE_TEST)
    testImplementation(TestLibs.MOCKITO_INLINE)
    testImplementation(TestLibs.MOKITO_KOTLIN)
    testImplementation(TestLibs.MOCKK)
    testImplementation(TestLibs.kOTLINX_COUROUTINE)
    testImplementation(TestLibs.kOTLINX_COUROUTINE_TEST)

}