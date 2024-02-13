package br.com.dmcconsulting.analytics

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import javax.inject.Inject

/**
 * Implementation of [AnalyticsHelper] that logs analytics events using Firebase Analytics.
 *
 * This class integrates with Firebase Analytics to log analytics events. It implements the [AnalyticsHelper] interface
 * and provides methods to log events with additional parameters, limiting the length of keys and values as needed.
 *
 * @property firebaseAnalytics The Firebase Analytics instance used for logging events.
 */
class FirebaseAnalyticsHelper @Inject constructor(
    private val firebaseAnalytics: FirebaseAnalytics,
) : AnalyticsHelper {

    /**
     * Logs the specified [event] to Firebase Analytics.
     *
     * This method delegates the logging of analytics events to Firebase Analytics, using the event type
     * and a bundle generated from the event's extras.
     *
     * @param event The [AnalyticsEvent] to be logged.
     */
    override fun logEvent(event: AnalyticsEvent) {
        firebaseAnalytics.logEvent(event.type, generateBundle(event))
    }

    /**
     * Generates a [Bundle] from the provided [event], limiting the length of keys and values.
     *
     * The keys and values in the [AnalyticsEvent] extras are truncated to ensure they do not exceed predefined
     * maximum lengths. The resulting [Bundle] is returned, or null if it is empty.
     *
     * @param event The [AnalyticsEvent] from which to generate the bundle.
     * @return A [Bundle] containing truncated keys and values, or null if the bundle is empty.
     */
    private fun generateBundle(event: AnalyticsEvent): Bundle? {
        val bundle = Bundle()

        // Iterate through the extras and limit the length of keys and values
        event.extras.forEach { (key, value) ->
            val finalKey = key.limitLength(MAX_LENGTH_KEY)
            val finalValue = value.limitLength(MAX_LENGTH_VALUE)
            bundle.putString(finalKey, finalValue)
        }

        // Return the bundle only if it contains any data
        return bundle.takeIf { it.size() > 0 }
    }

    /**
     * Internal companion object containing constants related to maximum lengths for keys and values.
     */
    private companion object {
        private const val MAX_LENGTH_KEY = 40
        private const val MAX_LENGTH_VALUE = 100
    }
}
