package br.com.dmcconsulting.movie.data.network

import br.com.dmcconsulting.common.mediatype.MediaType
import br.com.dmcconsulting.framework.result.ResponseAsync
import br.com.dmcconsulting.movie.data.network.model.MovieResponseDto
import br.com.dmcconsulting.networkimpl.util.DEFAULT_PAGE

/**
 * Interface for a data source responsible for fetching movies of a specific media type from a remote API.
 */
interface MovieNetworkDataSource {
    suspend fun getMoviesByMediaType(
        mediaType: MediaType,
        page: Int = DEFAULT_PAGE
    ): ResponseAsync<MovieResponseDto>
}