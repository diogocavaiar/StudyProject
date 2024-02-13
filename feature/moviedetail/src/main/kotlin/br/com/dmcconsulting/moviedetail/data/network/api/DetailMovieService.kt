package br.com.dmcconsulting.moviedetail.data.network.api

import br.com.dmcconsulting.framework.result.ResponseAsync
import br.com.dmcconsulting.moviedetail.data.network.model.MovieDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Interface that defines various API endpoints for retrieving movie-related data.
 */
interface DetailMovieService {
    /**
     * Retrieves detailed information about a specific movie.
     *
     * @param id The unique identifier of the movie.
     * @param appendToResponse Additional information to append to the response.
     * @return A [ResponseAsync] containing the response data in [MovieDetailsDto].
     */
    @GET("movie/{id}")
    suspend fun getMovieDetailBy(
        @Path("id") id: Int,
        @Query("append_to_response") appendToResponse: String = "credits"
    ): ResponseAsync<MovieDetailsDto>
}


