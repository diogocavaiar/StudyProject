package br.com.dmcconsulting.moviedetail.domain.usecase

import br.com.dmcconsulting.common.result.Result
import br.com.dmcconsulting.moviedetail.domain.model.MovieDetailsModel
import br.com.dmcconsulting.moviedetail.domain.repository.MovieDetailRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/**
 * Use case class for retrieving detailed information about a movie by its ID.
 *
 * This class is responsible for invoking the [MovieDetailRepository] to get detailed information
 * about a movie identified by the specified [id].
 *
 * @property repository The repository responsible for handling movie detail-related data operations.
 */
class GetMovieDetailByIdUseCase @Inject constructor(
    private val repository: MovieDetailRepository
) {
    /**
     * Invokes the use case to retrieve detailed information about a movie by its ID.
     *
     * @param id The ID of the movie for which detailed information is requested.
     * @return A [Flow] emitting the result, which includes the detailed information about the movie
     *         or an error.
     */
    suspend operator fun invoke(id: String?): Flow<Result<MovieDetailsModel?>> {
        // Convert the provided ID to an integer; use 0 if the conversion fails.
        val movieId = id?.toIntOrNull() ?: 0
        return repository.getMovieDetailBy(movieId)
    }
}
