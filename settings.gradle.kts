pluginManagement {
    includeBuild("plugins")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "StudyProject"
include(":app")
include(":core")
include(":core:network")
include(":core:designsystem")
include(":core:common")
include(":feature")
include(":feature:movie")
include(":feature:moviedetail")
include(":core:navigation")
include(":core:model")
include(":core:network-framework")
include(":core:ui")
include(":core:analytics")
