plugins {
    id("dmc.android.library")
    id("dmc.android.library.compose")
    id("dmc.android.hilt")
}

android {
    namespace = "br.com.dmcconsulting.analytics"
}

dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.compose.runtime)
    implementation(libs.androidx.corektx)
    implementation(libs.firebase.analytics)
    implementation(libs.kotlinx.coroutines.android)
}
