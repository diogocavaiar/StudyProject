package br.com.dmcconsulting.movie.data.network.api

import br.com.dmcconsulting.networkimpl.configuration.AccessTokenProvider
import br.com.dmcconsulting.networkimpl.configuration.BaseUrlProvider
import br.com.dmcconsulting.networkimpl.initialize.createInstanceRetrofit
import javax.inject.Inject
import retrofit2.create

/**
 * Class for accessing the movie service API.
 *
 * @property accessTokenProvider Provider for the access token.
 * @property baseUrlProvider Provider for the base URL.
 */
class MovieApi @Inject constructor(
    private val accessTokenProvider: AccessTokenProvider,
    private val baseUrlProvider: BaseUrlProvider
) {
    /** Retrofit service interface for movie API calls. */
    val movieService: MovieApiService by lazy {
        createInstanceRetrofit(
            baseUrlProvider,
            accessTokenProvider
        ).create()
    }
}
