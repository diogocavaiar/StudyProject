import com.android.build.gradle.LibraryExtension
import java.util.Properties
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/**
 * Plugin for configuring API provider conventions.
 */
class ApiProviderConventionPlugin : Plugin<Project> {
    /**
     * Applies the plugin to the given project.
     *
     * @param target The target project to apply the plugin to.
     */
    override fun apply(target: Project) {
        with(target) {
            val localProperties = Properties()
            val localPropertiesFile = rootProject.file("local.properties")

            // Load properties from local.properties file if it exists
            if (localPropertiesFile.exists() && localPropertiesFile.isFile) {
                localPropertiesFile.inputStream().use { input ->
                    localProperties.load(input)
                }
            }

            // Get base URL and access token from local.properties
            val baseUrl = localProperties.getProperty("baseUrl")
            val accessToken = localProperties.getProperty("accessToken")

            // Configure build features and build config fields
            extensions.configure<LibraryExtension> {
                buildFeatures.buildConfig = true
                defaultConfig {
                    buildConfigField("String", "BASE_URL", "\"$baseUrl\"")
                    buildConfigField("String", "ACCESS_TOKEN", "\"$accessToken\"")
                }
            }
        }
    }
}
