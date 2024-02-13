package br.com.dmcconsulting.moviedetail.data.mapper

import br.com.dmcconsulting.moviedetail.data.network.model.GenreDto
import br.com.dmcconsulting.moviedetail.domain.model.GenreModel

/**
 * Internal extension function to convert a [GenreDto] to a [GenreModel].
 *
 * @return A [GenreModel] representing the genre information.
 */
internal fun GenreDto.asGenreModel() = GenreModel(name)

/**
 * Internal extension function to convert a list of [GenreDto] to a list of [GenreModel].
 *
 * @return A list of [GenreModel] representing the genre information.
 */
internal fun List<GenreDto>.asGenreModels() = map(GenreDto::asGenreModel)

