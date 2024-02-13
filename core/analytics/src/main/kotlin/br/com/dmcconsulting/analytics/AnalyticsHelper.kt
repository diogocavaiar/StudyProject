package br.com.dmcconsulting.analytics

/**
 * Interface for a helper class responsible for logging analytics events.
 */
interface AnalyticsHelper {

    /**
     * Logs the specified [event] to the analytics system.
     *
     * Implementations of this method should handle the actual logging of the analytics event
     * based on the provided [event] parameters.
     *
     * @param event The [AnalyticsEvent] to be logged.
     */
    fun logEvent(event: AnalyticsEvent)
}