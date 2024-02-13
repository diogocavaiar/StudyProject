plugins {
    id("dmc.android.library")
}

android {
    namespace = "br.com.dmcconsulting.navigation"
}

dependencies {
    api(libs.navigation.compose)
}