package br.com.dmcconsulting.analytics

/**
 * Represents an analytics event that can be tracked in the application.
 *
 * @property type The type of the analytics event.
 * @property extras Additional parameters associated with the event.
 */
data class AnalyticsEvent(
    val type: String,
    val extras: List<Param> = emptyList(),
) {

    /**
     * Represents a parameter for an analytics event.
     *
     * @property key The key of the parameter.
     * @property value The value of the parameter.
     */
    data class Param(val key: String, val value: String)

    /**
     * Provides predefined types for analytics events.
     */
    class Types {
        companion object {
            /**
             * Type constant for screen view events.
             */
            const val SCREEN_VIEW = "screen_view"
        }
    }

    /**
     * Provides predefined keys for common parameters.
     */
    class ParamKeys {
        companion object {
            /**
             * Key constant for screen name parameter.
             */
            const val SCREEN_NAME = "screen_name"
        }
    }
}
