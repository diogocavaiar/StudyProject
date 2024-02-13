package br.com.dmcconsulting.moviedetail.data.mapper

import br.com.dmcconsulting.common.extension.minuteToRelativeTime
import br.com.dmcconsulting.moviedetail.data.network.model.MovieDetailsDto
import br.com.dmcconsulting.moviedetail.domain.model.MovieDetailsModel
import br.com.dmcconsulting.networkimpl.util.asImageUrl

/**
 * Extension function to convert a [MovieDetailsDto] to a [MovieDetailsModel].
 *
 * @return A [MovieDetailsModel] representing movie details information.
 */
fun MovieDetailsDto.asMovieDetailsModel() = MovieDetailsModel(
    backdropPath = backdropPath.asImageUrl(),
    genres = genres.asGenreModels(),
    overview = overview,
    posterPath = posterPath.asImageUrl(),
    releaseDate = releaseDate?.year.toString(),
    runtime = runtime?.minuteToRelativeTime(),
    title = title,
    credits = credits.asCreditsModel(),
)

