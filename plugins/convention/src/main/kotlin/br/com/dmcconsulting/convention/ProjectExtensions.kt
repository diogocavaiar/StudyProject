package br.com.dmcconsulting.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

/**
 * Gets the version catalog for project libraries.
 */
val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

/**
 * Finds a library in the project by its name.
 *
 * @param library The name of the library to find.
 * @return The found library.
 * @throws IllegalStateException if the library is not found.
 */
fun Project.findLibrary(library: String) = libs.findLibrary(library).get()

