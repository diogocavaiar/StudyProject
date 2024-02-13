package br.com.dmcconsulting.networkimpl.interceptor

import br.com.dmcconsulting.networkimpl.configuration.AccessTokenProvider
import br.com.dmcconsulting.networkimpl.configuration.requireAccessToken
import br.com.dmcconsulting.networkimpl.util.Constants
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor for adding authorization headers to outgoing HTTP requests.
 *
 * @property accessTokenProvider Provider for the access token.
 */
internal class AuthorizationInterceptor(
    private val accessTokenProvider: AccessTokenProvider
) : Interceptor {

    /**
     * Intercepts the HTTP request and adds an Authorization header with a hardcoded Bearer token.
     *
     * @param chain The interceptor chain.
     * @return The intercepted response.
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val newRequest = request
            .newBuilder()
            .header(AUTHORIZATION_HEADER, "Bearer " + accessTokenProvider.requireAccessToken())
            .build()

        return chain.proceed(newRequest)
    }

    private companion object {
        private const val AUTHORIZATION_HEADER = Constants.AUTHORIZATION_HEADER
    }
}
