package br.com.dmcconsulting.networkimpl.util

/**
 * Object containing constant values used throughout the application.
 */
internal object Constants {
    internal const val IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    internal const val DEFAULT_PAGE = 1
    internal const val AUTHORIZATION_HEADER = "Authorization"
}

/**
 * Published constant values derived from Constants.
 */
const val DEFAULT_PAGE = Constants.DEFAULT_PAGE

/**
 * Published constant message for unhandled state.
 */
@PublishedApi
internal const val MESSAGE_UNHANDLED_STATE = "Unhandled state."
