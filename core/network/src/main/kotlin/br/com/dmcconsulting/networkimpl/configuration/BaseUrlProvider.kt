package br.com.dmcconsulting.networkimpl.configuration

/**
 * Interface for providing base URLs.
 */
interface BaseUrlProvider {
    /** The base URL. */
    val baseUrl: String?
}

/**
 * Internal extension function to retrieve the base URL from a [BaseUrlProvider].
 * Throws an [IllegalStateException] if the base URL is null.
 */
internal fun BaseUrlProvider.getBaseUrl(): String {
    return checkNotNull(baseUrl) { "Base URL must not be null" }
}
