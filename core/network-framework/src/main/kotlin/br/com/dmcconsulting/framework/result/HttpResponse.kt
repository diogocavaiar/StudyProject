package br.com.dmcconsulting.framework.result

/**
 * Interface representing an HTTP response.
 */
internal interface HttpResponse {
    /** The HTTP status code of the response. */
    val statusCode: Int

    /** The optional status message associated with the response. */
    val statusMessage: String?

    /** The optional URL associated with the response. */
    val url: String?
}

