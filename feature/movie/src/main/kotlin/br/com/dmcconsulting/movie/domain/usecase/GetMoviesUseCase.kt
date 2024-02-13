package br.com.dmcconsulting.movie.domain.usecase

import br.com.dmcconsulting.common.mediatype.MediaType
import br.com.dmcconsulting.movie.domain.repository.MovieRepository
import javax.inject.Inject

/**
 * Use case for retrieving movies.
 *
 * @property repository The repository for movie data.
 */
class GetMoviesUseCase @Inject constructor(private val repository: MovieRepository) {

    /**
     * Invokes the use case to get movies of the specified media type.
     *
     * @param mediaTypeModel The media type model (e.g., MediaType.Movie).
     * @return A list of movies based on the specified media type.
     */
    suspend operator fun invoke(mediaTypeModel: MediaType.Movie) =
        repository.getMoviesByMediaType(mediaTypeModel)
}


