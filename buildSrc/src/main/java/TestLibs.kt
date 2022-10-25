object TestLibs {
    private val v = BuildDepVersions

    //TEST -----------------------------------------------------------------------------------------------
    const val JUNIT = "junit:junit:4.13.2"
    const val CORE_TEST = "androidx.arch.core:core-testing:2.1.0"
    const val MOCKITO_INLINE = "org.mockito:mockito-inline:4.5.1"
    const val MOKITO_KOTLIN = "org.mockito.kotlin:mockito-kotlin:4.0.0"
    const val MOCKK = "io.mockk:mockk:1.12.4"
    const val IOMOCKK_ANDROID = "io.mockk:mockk-android:1.12.4"
    const val TEST_RUNNER = "androidx.test:runner:1.4.0"
    const val TEST_RUNNER_EXT = "androidx.test.ext:junit:1.1.3"
    const val EXPRESSO_TEST = "androidx.test.espresso:espresso-core:3.4.0"
    const val TEST_RULE = "androidx.test:core:1.4.0"
    const val MOCKWEBSERVER = "com.squareup.okhttp3:mockwebserver:4.9.0"
    const val kOTLINX_COUROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    const val kOTLINX_COUROUTINE_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:2.38.1"


    //ANDROID TEST-----------------------------------------------------------------------------------------
    const val JUNIT_ANDROID = "junit:junit:4.13.2"
    const val TEST_RUNNER_ANDROID = "androidx.test:runner:1.4.0"
    const val kOTLINX_COUROUTINE_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    const val CoreTesting_ANDROID = "androidx.arch.core:core-testing:2.1.0"
    const val Hilt_ANDROID = "com.google.dagger:hilt-android-testing:2.44"
    const val Truth_ANDROID = "com.google.truth:truth:1.1.3"


    const val JUNIT_EXT_ANDROID = "androidx.test.ext:junit:${v.JUNIT_EXT_ANDROID}"
    const val EXPRESSO = "androidx.test.espresso:espresso-core:${v.EXPRESSO}"
    const val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test-junit4:${v.COMPOSE}"

    //DEBUG -----------------------------------------------------------------------------------------
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${v.COMPOSE}"


}