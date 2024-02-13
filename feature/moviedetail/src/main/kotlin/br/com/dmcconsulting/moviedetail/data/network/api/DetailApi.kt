package br.com.dmcconsulting.moviedetail.data.network.api

import br.com.dmcconsulting.networkimpl.configuration.AccessTokenProvider
import br.com.dmcconsulting.networkimpl.configuration.BaseUrlProvider
import br.com.dmcconsulting.networkimpl.initialize.createInstanceRetrofit
import javax.inject.Inject
import retrofit2.create

/**
 * API class for accessing detail movie services.
 *
 * @property accessTokenProvider Provider for accessing access tokens.
 * @property baseUrlProvider Provider for accessing base URLs.
 */
class DetailApi @Inject constructor(
    private val accessTokenProvider: AccessTokenProvider,
    private val baseUrlProvider: BaseUrlProvider
) {
    /**
     * Lazy-initialized instance of [DetailMovieService] for accessing detail movie endpoints.
     */
    val detailMovieService: DetailMovieService by lazy {
        createInstanceRetrofit(
            baseUrlProvider,
            accessTokenProvider
        ).create()
    }
}
