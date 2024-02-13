package br.com.dmcconsulting.ui.analytics

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import br.com.dmcconsulting.analytics.AnalyticsEvent
import br.com.dmcconsulting.analytics.AnalyticsHelper
import br.com.dmcconsulting.analytics.LocalAnalyticsHelper

/**
 * Logs a screen view event for analytics tracking.
 *
 * This extension function is part of the [AnalyticsHelper] and facilitates logging screen view events
 * for analytics purposes. It creates an [AnalyticsEvent] of type [AnalyticsEvent.Types.SCREEN_VIEW] with
 * additional parameters, such as the screen name.
 *
 * @param screenName The name or identifier of the screen being viewed.
 */
fun AnalyticsHelper.logScreenView(screenName: String) {
    logEvent(
        AnalyticsEvent(
            type = AnalyticsEvent.Types.SCREEN_VIEW,
            extras = listOf(
                AnalyticsEvent.Param(AnalyticsEvent.ParamKeys.SCREEN_NAME, screenName),
            ),
        )
    )
}


/**
 * Composable function for tracking a screen view event in analytics.
 *
 * This composable function logs a screen view event using the provided [AnalyticsHelper].
 * It is typically used to automatically track screen views when the composable is first
 * composed in a composable hierarchy.
 *
 * @param screenName The name or identifier of the screen being viewed.
 * @param analyticsHelper The [AnalyticsHelper] instance to use for logging the screen view event.
 *                         It defaults to the [LocalAnalyticsHelper.current], which is retrieved
 *                         from the composition local.
 */
@Composable
fun TrackScreenViewEvent(
    screenName: String,
    analyticsHelper: AnalyticsHelper = LocalAnalyticsHelper.current,
) = DisposableEffect(Unit) {
    // Log the screen view event when the composable is first composed
    analyticsHelper.logScreenView(screenName)

    // No-op onDispose function as there's no cleanup required
    onDispose {}
}
