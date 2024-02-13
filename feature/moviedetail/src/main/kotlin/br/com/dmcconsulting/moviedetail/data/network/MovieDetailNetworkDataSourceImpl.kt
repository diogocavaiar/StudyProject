package br.com.dmcconsulting.moviedetail.data.network

import br.com.dmcconsulting.framework.result.ResponseAsync
import br.com.dmcconsulting.moviedetail.data.network.model.MovieDetailsDto
import br.com.dmcconsulting.moviedetail.data.network.api.DetailMovieService
import javax.inject.Inject

/**
 * Implementation of [MovieDetailNetworkDataSource] that retrieves movie details from a remote API.
 *
 * @param service The [DetailMovieService] used to make network requests.
 */
class MovieDetailNetworkDataSourceImpl @Inject constructor(
    private val service: DetailMovieService
) : MovieDetailNetworkDataSource {
    /**
     * Retrieves detailed information about a specific movie from the remote API.
     *
     * @param id The unique identifier of the movie.
     * @return A [ResponseAsync] containing the response data in [MovieDetailsDto].
     */
    override suspend fun getMovieDetailBy(id: Int): ResponseAsync<MovieDetailsDto> =
        service.getMovieDetailBy(id)
}

