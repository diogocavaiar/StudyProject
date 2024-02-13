package br.com.dmcconsulting.analytics

import androidx.compose.runtime.staticCompositionLocalOf

/**
 * CompositionLocal used to provide and access an instance of [AnalyticsHelper] within a composition.
 *
 * This CompositionLocal variable allows the injection and retrieval of an [AnalyticsHelper] instance
 * within a Jetpack Compose composition. It is used to provide analytics functionality to composables
 * in a local scope.
 *
 * The default value is [NoOpAnalyticsHelper], which is a no-operation implementation of [AnalyticsHelper].
 *
 * Usage Example:
 * ```
 * val analyticsHelper = LocalAnalyticsHelper.current
 * analyticsHelper.logEvent(analyticsEvent)
 * ```
 */
val LocalAnalyticsHelper = staticCompositionLocalOf<AnalyticsHelper> {
    NoOpAnalyticsHelper()
}