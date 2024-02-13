package br.com.dmcconsulting.convention

import org.gradle.kotlin.dsl.DependencyHandlerScope

/**
 * Adds an implementation dependency.
 *
 * @param dependencyNotation The notation of the dependency to be added.
 */
fun DependencyHandlerScope.addImplementation(dependencyNotation: Any) {
    add("implementation", dependencyNotation)
}

/**
 * Adds a test implementation dependency.
 *
 * @param dependencyNotation The notation of the dependency to be added.
 */
fun DependencyHandlerScope.addTestImplementation(dependencyNotation: Any) {
    add("testImplementation", dependencyNotation)
}

/**
 * Adds an Android test implementation dependency.
 *
 * @param dependencyNotation The notation of the dependency to be added.
 */
fun DependencyHandlerScope.addAndroidTestImplementation(dependencyNotation: Any) {
    add("androidTestImplementation", dependencyNotation)
}

/**
 * Adds a kapt test dependency.
 *
 * @param dependencyNotation The notation of the dependency to be added.
 */
fun DependencyHandlerScope.addKaptTest(dependencyNotation: Any) {
    add("kaptTest", dependencyNotation)
}

/**
 * Adds a kapt dependency.
 *
 * @param dependencyNotation The notation of the dependency to be added.
 */
fun DependencyHandlerScope.addKapt(dependencyNotation: Any) {
    add("kapt", dependencyNotation)
}

/**
 * Adds a kapt Android test dependency.
 *
 * @param dependencyNotation The notation of the dependency to be added.
 */
fun DependencyHandlerScope.addKaptAndroidTest(dependencyNotation: Any) {
    add("kaptAndroidTest", dependencyNotation)
}