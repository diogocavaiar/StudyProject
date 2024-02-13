package br.com.dmcconsulting.moviedetail.domain.repository

import br.com.dmcconsulting.common.result.Result
import br.com.dmcconsulting.moviedetail.domain.model.MovieDetailsModel
import kotlinx.coroutines.flow.Flow

interface MovieDetailRepository {
    suspend fun getMovieDetailBy(id: Int): Flow<Result<MovieDetailsModel?>>
}