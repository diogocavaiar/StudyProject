package br.com.dmcconsulting.common.result

import kotlinx.coroutines.flow.Flow

/**
 * Interface defining asynchronous handling methods for loading, success, and failure states.
 *
 * This interface is designed to handle asynchronous operations and provides callbacks for different states.
 *
 * @param T The type of data being handled asynchronously.
 */
interface AsyncHandler<T> {
    /**
     * Callback for handling loading state.
     *
     * @param block The block to execute when in the loading state. It receives an optional result of type [T].
     */
    suspend fun onLoading(block: (T?) -> Unit)

    /**
     * Callback for handling success state.
     *
     * @param block The block to execute when in the success state. It receives the successful result of type [T].
     */
    suspend fun onSuccess(block: (T) -> Unit)

    /**
     * Callback for handling failure state.
     *
     * @param block The block to execute when in the failure state. It receives the encountered [Throwable].
     */
    suspend fun onFailure(block: (Throwable) -> Unit)
}

/**
 * Extension function to handle the result of an asynchronous operation using the provided [AsyncHandler] builder.
 *
 * This function creates an [AsyncHandler] and delegates handling of different states (loading, success, failure)
 * based on the provided builder function.
 *
 * @param builder The builder function to configure the [AsyncHandler] callbacks.
 */
private suspend fun <T> Result<T>.handle(builder: suspend AsyncHandler<T>.() -> Unit) {
    val resultHandler = object : AsyncHandler<T> {
        override suspend fun onLoading(block: (T?) -> Unit) {
            if (isLoading()) block(null)
        }

        override suspend fun onSuccess(block: (T) -> Unit) {
            if (isSuccess()) block(value)
        }

        override suspend fun onFailure(block: (Throwable) -> Unit) {
            if (isFailure()) block(error)
        }
    }

    builder(resultHandler)
}

/**
 * Extension function for handling a flow of results asynchronously using the provided [AsyncHandler] builder.
 *
 * This function collects results from the flow and delegates handling to the [AsyncHandler] based on the provided builder function.
 *
 * @param builder The builder function to configure the [AsyncHandler] callbacks.
 */
suspend fun <T> Flow<Result<T>>.handle(builder: suspend AsyncHandler<T>.() -> Unit) =
    collect { result -> result.handle(builder = builder) }

