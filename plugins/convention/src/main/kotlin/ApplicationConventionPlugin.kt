import br.com.dmcconsulting.convention.configureKotlinAndroid
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Plugin for configuring conventions for Android applications.
 */
class ApplicationConventionPlugin : Plugin<Project> {
    /**
     * Applies the plugin to the given project.
     *
     * @param target The target project to apply the plugin to.
     */
    override fun apply(target: Project) {
        with(target) {
            // Apply Android application and Kotlin Android plugins
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            // Configure Android application extension
            extensions.configure<BaseAppModuleExtension> {
                configureKotlinAndroid(this)
                buildFeatures.buildConfig = true

                // Configure default config settings
                defaultConfig {
                    targetSdk = 33

                    // Configure release build type
                    buildTypes {
                        release {
                            isMinifyEnabled = true
                            proguardFiles(
                                getDefaultProguardFile("proguard-android-optimize.txt"),
                                "proguard-rules.pro"
                            )

                            // Exclude DebugProbesKt.bin from packaging
                            packagingOptions.resources.excludes += "DebugProbesKt.bin"
                        }
                    }

                    // Exclude certain files from packaging
                    packaging {
                        resources {
                            excludes += "/META-INF/{AL2.0,LGPL2.1}"
                            excludes += "META-INF/LICENSE.md"
                            excludes += "META-INF/LICENSE-notice.md"
                        }
                    }
                }
            }
        }
    }
}
