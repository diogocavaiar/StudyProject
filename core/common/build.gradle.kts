plugins {
    id("dmc.android.library")
    id("dmc.android.hilt")
    id("kotlinx-serialization")
}

android {
    namespace = "br.com.dmcconsulting.common"
}

dependencies {
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.kotlinx.datetime)
}