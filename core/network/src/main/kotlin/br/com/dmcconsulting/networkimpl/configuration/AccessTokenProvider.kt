package br.com.dmcconsulting.networkimpl.configuration

/**
 * Interface for providing access tokens.
 */
interface AccessTokenProvider {
    /** The access token. */
    val accessToken: String?
}

/**
 * Internal extension function to require an access token from an [AccessTokenProvider].
 * Throws an [IllegalStateException] if the access token is null.
 */
internal fun AccessTokenProvider.requireAccessToken(): String {
    return checkNotNull(accessToken) { "Access token must not be null" }
}
