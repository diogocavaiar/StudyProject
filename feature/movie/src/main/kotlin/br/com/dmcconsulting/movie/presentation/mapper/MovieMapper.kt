package br.com.dmcconsulting.movie.presentation.mapper

import br.com.dmcconsulting.model.data.Movie
import br.com.dmcconsulting.movie.domain.model.MovieModel

/**
 * Extension function to convert a [MovieModel] to a [Movie].
 *
 * @return Converted [Movie] object.
 */
fun MovieModel.asMovie(): Movie =
    Movie(
        id = id,
        title = title,
        releaseDate = releaseDate?.year.toString(),
        posterPath = posterPath
    )

