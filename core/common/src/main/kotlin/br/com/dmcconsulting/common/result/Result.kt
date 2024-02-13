package br.com.dmcconsulting.common.result

/**
 * Sealed interface representing the result of an asynchronous operation.
 *
 * The result can be in one of the following states: Loading, Success, or Failure.
 *
 * @param T The type of data associated with the result.
 */
sealed interface Result<out T> {
    /**
     * Represents the loading state of an asynchronous operation.
     */
    data object Loading : Result<Nothing>

    /**
     * Sealed interface representing the success state of an asynchronous operation.
     *
     * @property value The successful result value.
     */
    sealed interface Success<out T> : Result<T> {
        val value: T

        /**
         * Represents a successful result value.
         *
         * @param value The successful result value.
         */
        class Value<T>(override val value: T) : Success<T> {
            override fun toString(): String = "Value($value)"
        }
    }

    /**
     * Sealed interface representing the failure state of an asynchronous operation.
     *
     * @property error The encountered [Throwable] during the operation.
     * @property value An optional value associated with the failure (can be null).
     */
    sealed interface Failure<out T> : Result<T> {
        val error: Throwable
        val value: T?

        /**
         * Represents a failure state with an error and an optional value.
         *
         * @param error The encountered [Throwable] during the operation.
         * @param value An optional value associated with the failure (can be null).
         */
        data class Error<T>(override val error: Throwable, override val value: T? = null) :
            Failure<T> {
            override fun toString(): String = "Error($error, $value)"
        }
    }

    /**
     * Companion object providing factory methods for creating different result states.
     */
    companion object {
        /**
         * Creates a loading result.
         *
         * @return The Loading result.
         */
        fun <T> loading() = Loading

        /**
         * Creates a success result with the provided [value].
         *
         * @param value The successful result value.
         * @return The Success result.
         */
        fun <T> success(value: T) = Success.Value(value)

        /**
         * Creates a failure result with the provided [error] and an optional [value].
         *
         * @param error The encountered [Throwable] during the operation.
         * @param value An optional value associated with the failure (can be null).
         * @return The Failure result.
         */
        fun <T> failure(error: Throwable, value: T? = null) = Failure.Error(error, value)
    }
}

