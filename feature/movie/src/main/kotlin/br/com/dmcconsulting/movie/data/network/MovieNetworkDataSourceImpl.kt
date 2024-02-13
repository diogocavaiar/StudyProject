package br.com.dmcconsulting.movie.data.network

import br.com.dmcconsulting.common.mediatype.MediaType
import br.com.dmcconsulting.framework.result.ResponseAsync
import br.com.dmcconsulting.movie.data.network.api.MovieApiService
import br.com.dmcconsulting.movie.data.network.model.MovieResponseDto
import javax.inject.Inject

/**
 * Implementation of [MovieNetworkDataSource] responsible for fetching movie data from a remote API.
 *
 * @property service An instance of [MovieApiService] for making API requests.
 */
class MovieNetworkDataSourceImpl @Inject constructor(
    private val service: MovieApiService
) : MovieNetworkDataSource {

    /**
     * Retrieves a list of movies based on the specified media type from the remote API.
     *
     * @param mediaType The type of media.
     * @param page The page number of the results.
     * @return A [ResponseAsync] containing the response data in [MovieResponseDto].
     */
    override suspend fun getMoviesByMediaType(
        mediaType: MediaType,
        page: Int
    ): ResponseAsync<MovieResponseDto> = when (mediaType) {
        MediaType.Movie.UPCOMING -> service.getUpcomingMovies(page)
        MediaType.Movie.TOP_RATED -> service.getTopRatedMovies(page)
        MediaType.Movie.POPULAR -> service.getPopularMovies(page)
        MediaType.Movie.NOW_PLAYING -> service.getNowPlayingMovies(page)
    }
}

