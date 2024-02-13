package br.com.dmcconsulting.movie.data.network.api

import br.com.dmcconsulting.framework.result.ResponseAsync
import br.com.dmcconsulting.movie.data.network.model.MovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    /**
     * Retrieves a list of movies currently playing in theaters.
     *
     * @param page The page number for paginated results.
     * @return A [ResponseAsync] containing the response data in [MovieResponseDto].
     */
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int = 1
    ): ResponseAsync<MovieResponseDto>

    /**
     * Retrieves a list of popular movies.
     *
     * @param page The page number for paginated results.
     * @return A [ResponseAsync] containing the response data in [MovieResponseDto].
     */
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1
    ): ResponseAsync<MovieResponseDto>

    /**
     * Retrieves a list of upcoming movies.
     *
     * @param page The page number for paginated results.
     * @return A [ResponseAsync] containing the response data in [MovieResponseDto].
     */
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int = 1
    ): ResponseAsync<MovieResponseDto>

    /**
     * Retrieves a list of top-rated movies.
     *
     * @param page The page number for paginated results.
     * @return A [ResponseAsync] containing the response data in [MovieResponseDto].
     */
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page: Int = 1
    ): ResponseAsync<MovieResponseDto>
}