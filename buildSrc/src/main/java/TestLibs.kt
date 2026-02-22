/**
 * Test library dependency coordinates for the project.
 * This object contains Maven coordinates for testing frameworks and tools
 * used in unit tests, instrumented tests, and UI tests.
 */
object TestLibs {
    /** Reference to version constants */
    private val v = BuildDepVersions

    //TEST -----------------------------------------------------------------------------------------------
    /** JUnit 4 testing framework for unit tests */
    const val JUNIT = "junit:junit:4.13.2"
    
    /** AndroidX Core testing utilities */
    const val CORE_TEST = "androidx.arch.core:core-testing:2.1.0"
    
    /** Mockito inline for mocking final classes */
    const val MOCKITO_INLINE = "org.mockito:mockito-inline:4.5.1"
    
    /** Mockito Kotlin extensions */
    const val MOKITO_KOTLIN = "org.mockito.kotlin:mockito-kotlin:4.0.0"
    
    /** MockK mocking library for Kotlin */
    const val MOCKK = "io.mockk:mockk:1.12.4"
    
    /** MockK Android variant for instrumented tests */
    const val IOMOCKK_ANDROID = "io.mockk:mockk-android:1.12.4"
    
    /** AndroidX test runner for instrumented tests */
    const val TEST_RUNNER = "androidx.test:runner:1.4.0"
    
    /** AndroidX test runner JUnit extension */
    const val TEST_RUNNER_EXT = "androidx.test.ext:junit:1.1.3"
    
    /** Espresso UI testing framework */
    const val EXPRESSO_TEST = "androidx.test.espresso:espresso-core:3.4.0"
    
    /** AndroidX test rules */
    const val TEST_RULE = "androidx.test:core:1.4.0"
    
    /** OkHttp MockWebServer for testing network calls */
    const val MOCKWEBSERVER = "com.squareup.okhttp3:mockwebserver:4.9.0"
    
    /** Kotlin Coroutines test library */
    const val kOTLINX_COUROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    
    /** Kotlin Coroutines test utilities */
    const val kOTLINX_COUROUTINE_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    
    /** Hilt Android compiler for test modules */
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:2.38.1"


    //ANDROID TEST-----------------------------------------------------------------------------------------
    /** JUnit for Android instrumented tests */
    const val JUNIT_ANDROID = "junit:junit:4.13.2"
    
    /** Test runner for Android instrumented tests */
    const val TEST_RUNNER_ANDROID = "androidx.test:runner:1.4.0"
    
    /** Coroutines test support for Android tests */
    const val kOTLINX_COUROUTINE_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    
    /** Core testing utilities for Android */
    const val CoreTesting_ANDROID = "androidx.arch.core:core-testing:2.1.0"
    
    /** Hilt testing library for Android */
    const val Hilt_ANDROID = "com.google.dagger:hilt-android-testing:2.44"
    
    /** Google Truth assertion library */
    const val Truth_ANDROID = "com.google.truth:truth:1.1.3"


    /** AndroidX JUnit extension for instrumented tests */
    const val JUNIT_EXT_ANDROID = "androidx.test.ext:junit:${v.JUNIT_EXT_ANDROID}"
    
    /** Espresso core for UI testing */
    const val EXPRESSO = "androidx.test.espresso:espresso-core:${v.EXPRESSO}"
    
    /** Compose UI test library for JUnit 4 */
    const val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test-junit4:${v.COMPOSE}"

    //DEBUG -----------------------------------------------------------------------------------------
    /** Compose UI tooling for debug builds */
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${v.COMPOSE}"


}