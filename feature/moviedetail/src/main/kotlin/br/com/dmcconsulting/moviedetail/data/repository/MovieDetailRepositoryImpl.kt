package br.com.dmcconsulting.moviedetail.data.repository

import br.com.dmcconsulting.common.result.Result
import br.com.dmcconsulting.moviedetail.data.mapper.asMovieDetailsModel
import br.com.dmcconsulting.moviedetail.data.network.MovieDetailNetworkDataSource
import br.com.dmcconsulting.moviedetail.domain.model.MovieDetailsModel
import br.com.dmcconsulting.moviedetail.domain.repository.MovieDetailRepository
import br.com.dmcconsulting.networkimpl.common.makeRequest
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/**
 * Implementation of [MovieDetailRepository] that retrieves movie details from a local database or a remote data source.
 *
 * @property remoteDataSource The remote network data source for movie details.
 */
class MovieDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieDetailNetworkDataSource
) : MovieDetailRepository {

    /**
     * Retrieves movie details by ID from either the local database or the remote network source.
     *
     * @param id The ID of the movie for which details are requested.
     * @return A Flow emitting the result of the movie details retrieval.
     */
    override suspend fun getMovieDetailBy(id: Int): Flow<Result<MovieDetailsModel?>> {
        return makeRequest(
            fetch = { remoteDataSource.getMovieDetailBy(id) },
            mapWhenSuccess = {
                it.asMovieDetailsModel()
            }
        )
    }
}

