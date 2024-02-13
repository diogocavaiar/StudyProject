package br.com.dmcconsulting.moviedetail.presentation.mapper

import br.com.dmcconsulting.model.data.Cast
import br.com.dmcconsulting.model.data.Credits
import br.com.dmcconsulting.model.data.Crew
import br.com.dmcconsulting.moviedetail.domain.model.CastModel
import br.com.dmcconsulting.moviedetail.domain.model.CreditsModel
import br.com.dmcconsulting.moviedetail.domain.model.CrewModel

/**
 * Converts a [CreditsModel] to a [Credits] object.
 *
 * @return Converted [Credits] object.
 */
internal fun CreditsModel.asCredits() = Credits(
    cast = cast.map(CastModel::asCast),
    crew = crew.map(CrewModel::asCrew)
)

/**
 * Converts a [CastModel] to a [Cast] object.
 *
 * @return Converted [Cast] object.
 */
private fun CastModel.asCast() = Cast(
    id = id,
    name = name,
    character = character,
    profilePath = profilePath
)

/**
 * Converts a [CrewModel] to a [Crew] object.
 *
 * @return Converted [Crew] object.
 */
private fun CrewModel.asCrew() = Crew(
    id = id,
    name = name,
    job = job,
    profilePath = profilePath
)

