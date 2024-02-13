import br.com.dmcconsulting.convention.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Plugin for configuring conventions for JVM libraries.
 */
class JvmLibraryConventionPlugin : Plugin<Project> {
    /**
     * Applies the plugin to the given project.
     *
     * @param target The target project to apply the plugin to.
     */
    override fun apply(target: Project) {
        with(target) {
            // Apply Kotlin JVM plugin
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
            }

            // Configure Kotlin JVM settings
            configureKotlinJvm()
        }
    }
}
