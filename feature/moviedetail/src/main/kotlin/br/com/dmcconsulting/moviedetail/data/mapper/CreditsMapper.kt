package br.com.dmcconsulting.moviedetail.data.mapper

import br.com.dmcconsulting.moviedetail.data.network.model.CastDto
import br.com.dmcconsulting.moviedetail.data.network.model.CreditsDto
import br.com.dmcconsulting.moviedetail.data.network.model.CrewDto
import br.com.dmcconsulting.moviedetail.domain.model.CastModel
import br.com.dmcconsulting.moviedetail.domain.model.CreditsModel
import br.com.dmcconsulting.moviedetail.domain.model.CrewModel
import br.com.dmcconsulting.networkimpl.util.asImageUrl


/**
 * Extension function to convert a [CreditsDto] to a [CreditsModel].
 *
 * This function maps the cast and crew lists from the [CreditsDto] to corresponding lists of [CastModel]
 * and [CrewModel] using their respective extension functions.
 *
 * @return A [CreditsModel] representing the credits information.
 */
fun CreditsDto.asCreditsModel() = CreditsModel(
    cast = cast.map(CastDto::asCastModel),
    crew = crew.map(CrewDto::asCrewModel)
)

/**
 * Extension function to convert a [CastDto] to a [CastModel].
 *
 * @return A [CastModel] representing cast information.
 */
fun CastDto.asCastModel() = CastModel(
    id = id,
    name = name,
    adult = adult,
    castId = castId,
    character = character,
    creditId = creditId,
    gender = gender,
    knownForDepartment = knownForDepartment,
    order = order,
    originalName = originalName,
    popularity = popularity,
    profilePath = profilePath.asImageUrl()
)

/**
 * Extension function to convert a [CrewDto] to a [CrewModel].
 *
 * @return A [CrewModel] representing crew information.
 */
fun CrewDto.asCrewModel() = CrewModel(
    id = id,
    adult = adult,
    creditId = creditId,
    department = department,
    gender = gender,
    job = job,
    knownForDepartment = knownForDepartment,
    name = name,
    originalName = originalName,
    popularity = popularity,
    profilePath = profilePath.asImageUrl()
)

