plugins {
    id("dmc.android.library")
    id("dmc.android.library.compose")
}

android {
    namespace = "br.com.dmcconsulting.ui"
}

dependencies {
    api(project(":core:analytics"))
    api(project(":core:designsystem"))
    api(project(":core:navigation"))
    api(project(":core:model"))
    implementation(libs.kotlinx.datetime)
}
