plugins {
    id("dmc.android.library")
    id("dmc.android.hilt")
    id("dmc.api.provider")
    id("kotlinx-serialization")
}

android {
    namespace = "br.com.dmcconsulting.networkimpl"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:network-framework"))
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(libs.kotlinx.datetime)
}
