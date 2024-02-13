import br.com.dmcconsulting.convention.addImplementation
import br.com.dmcconsulting.convention.findLibrary

plugins {
    id("dmc.android.library")
    id("dmc.android.library.compose")
}

android {
    namespace = "br.com.dmcconsulting.designsystem"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/LICENSE.md"
            excludes += "META-INF/LICENSE-notice.md"
        }
    }
}

dependencies {
    // Compose
    api(libs.bundles.compose)
    debugApi(libs.compose.ui.tooling)

    //ConstraintLayout
    api(libs.constraintlayout.compose)

    //Extend Icons
    api(libs.compose.icons.extended)
    api(libs.compose.ui.util)

    // MockK
    testImplementation(libs.mockk)
    androidTestImplementation(libs.mockk.android)

    //Lottie
    implementation(libs.lottie.compose)

    //Coil
    implementation(libs.coil.compose)

    // Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.compose.ui.test.junit4)
    debugApi(libs.compose.ui.test.manifest)
}