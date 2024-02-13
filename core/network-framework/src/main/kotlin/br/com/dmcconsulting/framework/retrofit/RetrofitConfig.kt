package br.com.dmcconsulting.framework.retrofit

import br.com.dmcconsulting.framework.configuration.MIMETYPE_JSON
import br.com.dmcconsulting.framework.configuration.createHttpClient
import br.com.dmcconsulting.framework.configuration.defaultJson
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.Interceptor
import retrofit2.Retrofit

/**
 * Utility function to create an instance of Retrofit.
 *
 * @param url The base URL for the Retrofit instance.
 * @param clientInterceptor Optional interceptor for OkHttpClient.
 * @return The configured Retrofit instance.
 */
fun retrofit(
    url: String,
    clientInterceptor: (() -> Interceptor)? = null,
): Retrofit = Retrofit.Builder()
    .baseUrl(url)
    .client(
        createHttpClient(
            clientInterceptor = clientInterceptor
        )
    )
    .addConverterFactory(defaultJson.asConverterFactory(MIMETYPE_JSON))
    .addCallAdapterFactory(ResultAdapterFactory())
    .build()