package br.com.dmcconsulting.moviedetail.presentation.mapper

import br.com.dmcconsulting.model.data.MovieDetails
import br.com.dmcconsulting.moviedetail.domain.model.MovieDetailsModel

/**
 * Converts a [MovieDetailsModel] to a [MovieDetails] object.
 *
 * @return Converted [MovieDetails] object.
 */
fun MovieDetailsModel.asMovieDetails() = MovieDetails(
    title = title,
    overview = overview,
    backdropPath = backdropPath,
    genres = genres.asGenres(),
    posterPath = posterPath,
    releaseDate = releaseDate,
    runtime = runtime,
    credits = credits.asCredits(),
)
