package br.com.dmcconsulting.moviedetail.data.network

import br.com.dmcconsulting.framework.result.ResponseAsync
import br.com.dmcconsulting.moviedetail.data.network.model.MovieDetailsDto

/**
 * Interface for a data source responsible for fetching movie details from a remote API.
 */
interface MovieDetailNetworkDataSource {
    suspend fun getMovieDetailBy(id: Int): ResponseAsync<MovieDetailsDto>
}