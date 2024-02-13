package br.com.dmcconsulting.movie.data.repository

import br.com.dmcconsulting.common.mediatype.MediaType
import br.com.dmcconsulting.common.result.Result
import br.com.dmcconsulting.movie.data.mapper.asMovieModel
import br.com.dmcconsulting.movie.data.network.MovieNetworkDataSource
import br.com.dmcconsulting.movie.domain.model.MovieModel
import br.com.dmcconsulting.movie.domain.repository.MovieRepository
import br.com.dmcconsulting.networkimpl.common.makeRequest
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/**
 * Implementation of [MovieRepository] that retrieves movies by media type from a local database or a remote data source.
 *
 * @property networkDataSource The remote network data source for movies.
 */
class MovieRepositoryImpl @Inject constructor(
    private val networkDataSource: MovieNetworkDataSource
) : MovieRepository {

    /**
     * Retrieves a list of movies by media type from either the local database or the remote network source.
     *
     * @param mediaType The media type for which movies are requested.
     * @return A Flow emitting the result of the movies retrieval.
     */
    override suspend fun getMoviesByMediaType(mediaType: MediaType.Movie): Flow<Result<List<MovieModel>>> {
        return makeRequest(
            fetch = { networkDataSource.getMoviesByMediaType(mediaType) },
            mapWhenSuccess = { movieResponseDto ->
                movieResponseDto.asMovieModel()
            }
        )
    }
}

