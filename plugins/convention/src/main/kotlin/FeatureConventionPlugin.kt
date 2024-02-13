import br.com.dmcconsulting.convention.addImplementation
import br.com.dmcconsulting.convention.findLibrary
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

/**
 * Plugin for configuring conventions for feature modules.
 */
class FeatureConventionPlugin : Plugin<Project> {
    /**
     * Applies the plugin to the given project.
     *
     * @param target The target project to apply the plugin to.
     */
    override fun apply(target: Project) {
        with(target) {
            // Apply custom feature module and Hilt plugins
            pluginManager.apply {
                apply("dmc.android.library")
                apply("dmc.android.hilt")
            }

            // Configure Android library extension
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    // Set test instrumentation runner
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }

            // Add dependencies for feature module
            dependencies {
                addImplementation(project(":core:common"))
                addImplementation(project(":core:network-framework"))
                addImplementation(project(":core:network"))
                addImplementation(project(":core:ui"))
                addImplementation(findLibrary("navigation-compose"))
                addImplementation(findLibrary("hilt-navigation-compose"))
                addImplementation(findLibrary("androidx-lifecycle-runtime-compose"))
                addImplementation(findLibrary("androidx-lifecycle-viewModel-compose"))
                addImplementation(findLibrary("kotlinx-coroutines-android"))
                addImplementation(findLibrary("kotlinx-datetime"))
            }
        }
    }
}
