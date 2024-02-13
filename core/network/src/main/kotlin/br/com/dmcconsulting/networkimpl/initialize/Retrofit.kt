package br.com.dmcconsulting.networkimpl.initialize

import br.com.dmcconsulting.framework.retrofit.retrofit
import br.com.dmcconsulting.networkimpl.configuration.AccessTokenProvider
import br.com.dmcconsulting.networkimpl.configuration.BaseUrlProvider
import br.com.dmcconsulting.networkimpl.configuration.getBaseUrl
import br.com.dmcconsulting.networkimpl.interceptor.AuthorizationInterceptor

/**
 * Creates an instance of Retrofit with the provided base URL and access token interceptor.
 *
 * @param baseUrlProvider Provider for the base URL.
 * @param accessTokenProvider Provider for the access token.
 * @return Retrofit instance.
 */
fun createInstanceRetrofit(
    baseUrlProvider: BaseUrlProvider,
    accessTokenProvider: AccessTokenProvider
) = retrofit(
    url = baseUrlProvider.getBaseUrl(),
    clientInterceptor = {
        AuthorizationInterceptor(accessTokenProvider)
    }
)
