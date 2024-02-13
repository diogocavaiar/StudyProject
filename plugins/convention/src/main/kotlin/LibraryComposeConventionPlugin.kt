import br.com.dmcconsulting.convention.configureAndroidCompose
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Plugin for configuring conventions for Compose-based libraries.
 */
class LibraryComposeConventionPlugin : Plugin<Project> {
    /**
     * Applies the plugin to the given project.
     *
     * @param target The target project to apply the plugin to.
     */
    override fun apply(target: Project) {
        with(target) {
            // Apply Android library plugin
            pluginManager.apply("com.android.library")

            // Configure Android library extension for Compose
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}

