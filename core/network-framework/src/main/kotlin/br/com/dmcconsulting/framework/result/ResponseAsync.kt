package br.com.dmcconsulting.framework.result

import br.com.dmcconsulting.framework.result.HttpResponse as HttpResponseInterface

/**
 * Represents an asynchronous response that can be in one of three states: Loading, Success, or Failure.
 * @param T The type of data associated with the response.
 */
sealed interface ResponseAsync<out T> {

    /**
     * Represents the loading state of the asynchronous response.
     * @param value The optional value associated with the loading state.
     */
    data class Loading<T>(val value: T? = null) : ResponseAsync<T>

    /**
     * Represents the successful state of the asynchronous response.
     * @param T The type of data associated with the success state.
     */
    sealed interface Success<out T> : ResponseAsync<T> {
        val value: T

        /**
         * Represents a successful HTTP response.
         * @param value The value associated with the success state.
         * @param statusCode The HTTP status code of the response.
         * @param statusMessage The optional status message of the response.
         * @param url The optional URL associated with the response.
         */
        data class HttpResponse<T>(
            override val value: T,
            override val statusCode: Int,
            override val statusMessage: String?,
            override val url: String?
        ) : Success<T>, HttpResponseInterface
    }

    /**
     * Represents the failure state of the asynchronous response.
     * @param T The type of data associated with the failure state.
     */
    sealed interface Failure<out T> : ResponseAsync<T> {
        val error: Throwable
        val value: T?

        /**
         * Represents a generic error in the failure state.
         * @param error The throwable error associated with the failure.
         * @param value The optional value associated with the failure state.
         */
        data class Error<T>(override val error: Throwable, override val value: T? = null) :
            Failure<T>

        /**
         * Represents an HTTP error in the failure state.
         * @param error The HTTP exception associated with the failure.
         * @param value The optional value associated with the failure state.
         */
        data class HttpError<T>(override val error: HttpException, override val value: T? = null) :
            Failure<T>, HttpResponseInterface {
            override val statusCode: Int = error.statusCode
            override val statusMessage: String? = error.statusMessage
            override val url: String? = error.url
        }
    }

    companion object {
        /**
         * Factory method to create a successful response.
         * @param value The value associated with the success state.
         * @param statusCode The HTTP status code of the response.
         * @param statusMessage The optional status message of the response.
         * @param url The optional URL associated with the response.
         * @return A [Success.HttpResponse] instance representing a successful response.
         */
        fun <T> success(value: T, statusCode: Int, statusMessage: String?, url: String?) =
            Success.HttpResponse(value, statusCode, statusMessage, url)

        /**
         * Factory method to create a failure response with a generic error.
         * @param error The throwable error associated with the failure.
         * @param value The optional value associated with the failure state.
         * @return A [Failure.Error] instance representing a failure with a generic error.
         */
        fun <T> failure(error: Throwable, value: T? = null) = Failure.Error(error, value)

        /**
         * Factory method to create a failure response with an HTTP error.
         * @param error The HTTP exception associated with the failure.
         * @param value The optional value associated with the failure state.
         * @return A [Failure.HttpError] instance representing a failure with an HTTP error.
         */
        fun <T> failure(error: HttpException, value: T? = null) = Failure.HttpError(error, value)
    }
}
