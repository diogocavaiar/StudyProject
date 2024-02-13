import br.com.dmcconsulting.convention.addImplementation
import br.com.dmcconsulting.convention.findLibrary
import com.android.build.api.dsl.ApplicationExtension
import com.google.firebase.crashlytics.buildtools.gradle.CrashlyticsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

/**
 * Plugin for configuring Firebase dependencies and settings in Android applications.
 */
class AndroidApplicationFirebaseConventionPlugin : Plugin<Project> {
    /**
     * Applies the plugin to the given project.
     *
     * @param target The target project to apply the plugin to.
     */
    override fun apply(target: Project) {
        with(target) {
            // Apply required Firebase plugins
            with(pluginManager) {
                apply("com.google.gms.google-services")
                apply("com.google.firebase.firebase-perf")
                apply("com.google.firebase.crashlytics")
            }

            // Add Firebase dependencies
            dependencies {
                val bom = findLibrary("firebase-bom")
                addImplementation(platform(bom))
                addImplementation(findLibrary("firebase.analytics"))
                addImplementation(findLibrary("firebase.performance"))
                addImplementation(findLibrary("firebase.crashlytics"))
            }

            // Configure Firebase settings
            extensions.configure<ApplicationExtension> {
                buildTypes.configureEach {
                    configure<CrashlyticsExtension> {
                        mappingFileUploadEnabled = false
                    }
                }
            }
        }
    }
}

