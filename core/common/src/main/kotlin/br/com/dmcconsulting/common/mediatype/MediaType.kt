package br.com.dmcconsulting.common.mediatype

/**
 * Sealed interface representing different media types for categorizing movies.
 *
 * This sealed interface allows the creation of specific movie-related media types, each defined as an enum class.
 *
 * Usage Example:
 * ```
 * val upcomingType = MediaType.Movie.UPCOMING
 * val mediaTypeString = upcomingType.mediaType
 * // The value of mediaTypeString is "upcoming"
 * ```
 */
sealed interface MediaType {
    /**
     * Enum class representing movie-related media types.
     *
     * Each enum constant represents a specific movie-related media type with an associated string value.
     *
     * @property mediaType The string representation of the movie-related media type.
     */
    enum class Movie(val mediaType: String) : MediaType {
        /**
         * Represents an upcoming movie-related media type.
         */
        UPCOMING(UPCOMING_MEDIA_TYPE),

        /**
         * Represents a top-rated movie-related media type.
         */
        TOP_RATED(TOP_RATED_MEDIA_TYPE),

        /**
         * Represents a popular movie-related media type.
         */
        POPULAR(POPULAR_MEDIA_TYPE),

        /**
         * Represents a now-playing movie-related media type.
         */
        NOW_PLAYING(NOW_PLAYING_MEDIA_TYPE);

        /**
         * Companion object providing utility functions for [Movie].
         */
        companion object {
            /**
             * Map associating movie-related media type strings with their corresponding [Movie] enum constants.
             */
            private val mediaTypes = entries.associateBy(Movie::mediaType)

            /**
             * Retrieves the [Movie] enum constant associated with the provided [mediaType] string.
             *
             * @param mediaType The string representation of the movie-related media type.
             * @return The [Movie] enum constant corresponding to the provided string.
             * @throws IllegalArgumentException if the provided media type is not recognized.
             */
            operator fun get(mediaType: String): Movie =
                checkNotNull(mediaTypes[mediaType]) { "$INVALID_MEDIA_TYPE_MESSAGE $mediaType" }
        }
    }
}

/**
 * Constant message for invalid media types.
 */
private const val INVALID_MEDIA_TYPE_MESSAGE = "Invalid media type."

/**
 * Constant representing the "upcoming" media type string.
 */
private const val UPCOMING_MEDIA_TYPE = "upcoming"

/**
 * Constant representing the "top_rated" media type string.
 */
private const val TOP_RATED_MEDIA_TYPE = "top_rated"

/**
 * Constant representing the "popular" media type string.
 */
private const val POPULAR_MEDIA_TYPE = "popular"

/**
 * Constant representing the "now_playing" media type string.
 */
private const val NOW_PLAYING_MEDIA_TYPE = "now_playing"
