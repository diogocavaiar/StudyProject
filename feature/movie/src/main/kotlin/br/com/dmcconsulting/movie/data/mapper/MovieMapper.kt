package br.com.dmcconsulting.movie.data.mapper

import br.com.dmcconsulting.movie.data.network.model.MovieDto
import br.com.dmcconsulting.movie.data.network.model.MovieResponseDto
import br.com.dmcconsulting.movie.domain.model.MovieModel
import br.com.dmcconsulting.networkimpl.util.asImageUrl

/**
 * Extension function to map a [MovieResponseDto] to a list of [MovieModel] instances.
 *
 * @return List of mapped [MovieModel] instances.
 */
internal fun MovieResponseDto.asMovieModel() = results.map(MovieDto::asMovieModel)

/**
 * Extension function to map a [MovieDto] to a [MovieModel].
 *
 * @return Mapped [MovieModel] instance.
 */
internal fun MovieDto.asMovieModel() = MovieModel(
    id = id,
    title = title,
    releaseDate = releaseDate,
    posterPath = posterPath.asImageUrl(),
)

