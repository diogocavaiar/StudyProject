package br.com.dmcconsulting.framework.configuration

import okhttp3.Interceptor
import okhttp3.OkHttpClient

/**
 * Creates an OkHttpClient with optional clientInterceptor and loggingLevel.
 *
 * @param clientInterceptor A function that provides a custom Interceptor if needed.
 * @return The configured OkHttpClient.
 */
internal fun createHttpClient(
    clientInterceptor: (() -> Interceptor)?
): OkHttpClient {
    return OkHttpClient
        .Builder()
        .addInterceptorIfNotNull(clientInterceptor?.invoke())
        .build()
}

/**
 * Adds the provided interceptor to the OkHttpClient builder if it is not null.
 *
 * @param interceptor The Interceptor to add (can be null).
 * @return The modified OkHttpClient builder.
 */
private fun OkHttpClient.Builder.addInterceptorIfNotNull(interceptor: Interceptor?): OkHttpClient.Builder {
    interceptor?.let {
        addInterceptor(it)
    }
    return this
}
