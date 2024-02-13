plugins {
    id("dmc.android.application")
    id("dmc.android.application.compose")
    id("dmc.android.hilt")
    id("kotlinx-serialization")
    alias(libs.plugins.dmc.android.application.firebase)
}

android {
    namespace = "br.com.dmcconsulting.studyproject"

    defaultConfig {
        applicationId = "br.com.dmcconsulting.studyproject"
        minSdk = 26
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
}

dependencies {
    implementation(project(":core:analytics"))
    implementation(project(":core:network"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:common"))
    implementation(project(":core:navigation"))
    implementation(project(":feature:movie"))
    implementation(project(":feature:moviedetail"))
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(libs.runner)
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.core.testing)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.compose.ui.test.junit4)

    //Navigation
    implementation(libs.navigation.compose)

    // Hilt Navigation
    implementation(libs.hilt.navigation.compose)

    // MockK
    testImplementation(libs.mockk)
    androidTestImplementation(libs.mockk.android)

    //Lifecycle
    implementation(libs.androidx.lifecycle.runtime.compose)
}