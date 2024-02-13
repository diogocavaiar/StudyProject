package br.com.dmcconsulting.analytics

import android.util.Log

/**
 * Implementation of AnalyticsHelper which does nothing. Useful for tests and previews.
 */
class NoOpAnalyticsHelper : AnalyticsHelper {
    override fun logEvent(event: AnalyticsEvent) {
        Log.d("AnalyticsHelper", event.toString())
    }
}
