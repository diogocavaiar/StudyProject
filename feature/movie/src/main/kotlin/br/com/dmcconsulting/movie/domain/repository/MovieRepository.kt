package br.com.dmcconsulting.movie.domain.repository

import br.com.dmcconsulting.common.mediatype.MediaType
import br.com.dmcconsulting.common.result.Result
import br.com.dmcconsulting.movie.domain.model.MovieModel
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getMoviesByMediaType(mediaType: MediaType.Movie): Flow<Result<List<MovieModel>>>
}