plugins {
    id("dmc.android.library")
    id("dmc.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "br.com.dmcconsulting.network.framework"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.logging.interceptor)
    testImplementation(libs.mockk)
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.1")
    api(libs.kotlinx.serialization.json)
    api(libs.bundles.retrofit)
}
