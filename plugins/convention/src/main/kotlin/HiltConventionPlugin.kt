import br.com.dmcconsulting.convention.addAndroidTestImplementation
import br.com.dmcconsulting.convention.addImplementation
import br.com.dmcconsulting.convention.addKapt
import br.com.dmcconsulting.convention.addKaptAndroidTest
import br.com.dmcconsulting.convention.addKaptTest
import br.com.dmcconsulting.convention.addTestImplementation
import br.com.dmcconsulting.convention.findLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Plugin for configuring conventions for Hilt dependency injection.
 */
class HiltConventionPlugin : Plugin<Project> {
    /**
     * Applies the plugin to the given project.
     *
     * @param target The target project to apply the plugin to.
     */
    override fun apply(target: Project) {
        with(target) {
            // Apply Hilt and Kotlin Kapt plugins
            with(pluginManager) {
                apply("dagger.hilt.android.plugin")
                apply("org.jetbrains.kotlin.kapt")
            }

            // Add Hilt dependencies
            dependencies {
                addImplementation(findLibrary("hilt-android"))
                addTestImplementation(findLibrary("hilt-android-testing"))
                addAndroidTestImplementation(findLibrary("hilt-android-testing"))
                addKaptTest(findLibrary("hilt-android-compiler"))
                addKapt(findLibrary("hilt-android-compiler"))
                addKaptAndroidTest(findLibrary("hilt-android-compiler"))
            }
        }
    }
}

