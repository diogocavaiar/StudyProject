package br.com.dmcconsulting.framework.retrofit

import br.com.dmcconsulting.framework.result.HttpException
import br.com.dmcconsulting.framework.result.ResponseAsync
import java.io.IOException
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A Retrofit [Call] delegate that wraps the response in a [ResponseAsync] type.
 *
 * This class extends [CallDelegate] and provides handling for both successful responses and errors.
 *
 * @param T The type of data expected in the response.
 * @property proxy The original Retrofit [Call] instance to be delegated.
 */
internal class ResultCall<T>(proxy: Call<T>) : CallDelegate<T, ResponseAsync<T>>(proxy) {

    /**
     * Enqueues the Retrofit call with a [ResultCallback] to handle the response.
     * @param callback The callback to be notified upon completion.
     */
    override fun enqueueImpl(callback: Callback<ResponseAsync<T>>) =
        proxy.enqueue(ResultCallback(this, callback))

    /**
     * Creates a new instance of [ResultCall] by cloning the original [Call].
     * @return A new instance of [ResultCall].
     */
    override fun cloneImpl(): ResultCall<T> = ResultCall(proxy.clone())

    /**
     * [ResultCallback] is responsible for handling the response callbacks for the Retrofit call.
     * @param T The type of data expected in the response.
     * @property proxy The original [ResultCall] instance.
     * @property callback The callback to be notified upon completion.
     */
    private class ResultCallback<T>(
        private val proxy: ResultCall<T>,
        private val callback: Callback<ResponseAsync<T>>
    ) : Callback<T> {

        /**
         * Handles the successful response by wrapping it in a [ResponseAsync.Success] or [ResponseAsync.Failure]
         * based on the success status of the HTTP response.
         */
        @Suppress("UNCHECKED_CAST")
        override fun onResponse(call: Call<T>, response: Response<T>) {
            val result = if (response.isSuccessful) {
                ResponseAsync.success(
                    value = response.body() as T,
                    statusCode = response.code(),
                    statusMessage = response.message(),
                    url = call.request().url.toString()
                )
            } else {
                ResponseAsync.failure(
                    HttpException(
                        statusCode = response.code(),
                        statusMessage = response.message(),
                        url = call.request().url.toString()
                    )
                )
            }
            callback.onResponse(proxy, Response.success(result))
        }

        /**
         * Handles the failure response by wrapping the error in a [ResponseAsync.Failure].
         * @param T The type of data expected in the response.
         * @param call The original Retrofit call.
         * @param error The throwable error associated with the failure.
         */
        override fun onFailure(call: Call<T>, error: Throwable) {
            val result = when (error) {
                is retrofit2.HttpException -> ResponseAsync.failure<T>(
                    HttpException(
                        statusCode = error.code(),
                        statusMessage = error.message(),
                        cause = error
                    )
                )
                is IOException -> ResponseAsync.failure(error)
                else -> ResponseAsync.failure(error)
            }

            callback.onResponse(proxy, Response.success(result))
        }
    }

    /**
     * Returns the timeout for the original Retrofit [Call].
     * @return The timeout for the original [Call].
     */
    override fun timeout(): Timeout = proxy.timeout()
}

