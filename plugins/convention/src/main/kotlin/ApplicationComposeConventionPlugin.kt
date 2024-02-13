import br.com.dmcconsulting.convention.configureAndroidCompose
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * Plugin for configuring conventions for Compose-based Android applications.
 */
class ApplicationComposeConventionPlugin : Plugin<Project> {
    /**
     * Applies the plugin to the given project.
     *
     * @param target The target project to apply the plugin to.
     */
    override fun apply(target: Project) {
        with(target) {
            // Apply Android application plugin
            pluginManager.apply("com.android.application")

            // Configure Android Compose extension
            val extension = extensions.getByType<BaseAppModuleExtension>()
            configureAndroidCompose(extension)
        }
    }
}

