plugins {
    `kotlin-dsl`
}

group = "br.com.dmcconsulting.plugins"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.firebase.crashlytics.gradle.plugin)
    compileOnly(libs.firebase.performance.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "dmc.android.application"
            implementationClass = "ApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "dmc.android.application.compose"
            implementationClass = "ApplicationComposeConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "dmc.android.library.compose"
            implementationClass = "LibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "dmc.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidHilt") {
            id = "dmc.android.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("androidFeature") {
            id = "dmc.android.feature"
            implementationClass = "FeatureConventionPlugin"
        }
        register("jvmLibrary") {
            id = "dmc.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
        register("androidFirebase") {
            id = "dmc.android.application.firebase"
            implementationClass = "AndroidApplicationFirebaseConventionPlugin"
        }
        register("apiProvider") {
            id = "dmc.api.provider"
            implementationClass = "ApiProviderConventionPlugin"
        }
    }
}
