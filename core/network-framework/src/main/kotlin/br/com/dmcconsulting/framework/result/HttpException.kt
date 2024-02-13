package br.com.dmcconsulting.framework.result

/**
 * Custom exception for representing HTTP errors.
 *
 * @property statusCode The HTTP status code associated with the exception.
 * @property statusMessage The optional status message associated with the exception.
 * @property url The optional URL associated with the exception.
 * @property cause The optional cause of the exception.
 */
class HttpException(
    val statusCode: Int,
    val statusMessage: String? = null,
    val url: String? = null,
    cause: Throwable? = null
) : Exception(null, cause) {

    /**
     * Returns a string representation of the HTTP exception.
     *
     * @return A string containing the status code, status message, URL, and cause.
     */
    override fun toString(): String {
        return "$statusCode $statusMessage $url $cause"
    }
}

