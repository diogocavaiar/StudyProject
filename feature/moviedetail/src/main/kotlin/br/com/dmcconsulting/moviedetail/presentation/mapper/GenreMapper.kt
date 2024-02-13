package br.com.dmcconsulting.moviedetail.presentation.mapper

import br.com.dmcconsulting.model.data.Genre
import br.com.dmcconsulting.moviedetail.domain.model.GenreModel

/**
 * Converts a list of [GenreModel] objects to a list of [Genre] objects.
 *
 * @return Converted list of [Genre] objects.
 */
internal fun List<GenreModel>.asGenres() = map(GenreModel::asGenre)

/**
 * Converts a [GenreModel] to a [Genre] object.
 *
 * @return Converted [Genre] object.
 */
private fun GenreModel.asGenre() = Genre(name = name)
