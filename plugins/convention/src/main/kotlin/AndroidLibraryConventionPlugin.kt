import br.com.dmcconsulting.convention.addAndroidTestImplementation
import br.com.dmcconsulting.convention.addTestImplementation
import br.com.dmcconsulting.convention.configureKotlinAndroid
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

/**
 * Plugin for configuring conventions for Android libraries.
 */
class AndroidLibraryConventionPlugin : Plugin<Project> {
    /**
     * Applies the plugin to the given project.
     *
     * @param target The target project to apply the plugin to.
     */
    override fun apply(target: Project) {
        with(target) {
            // Apply Android library and Kotlin Android plugins
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            // Configure Android library extension
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 33
            }

            // Add dependencies for tests
            dependencies {
                addAndroidTestImplementation(kotlin("test"))
                addTestImplementation(kotlin("test"))
            }
        }
    }
}
