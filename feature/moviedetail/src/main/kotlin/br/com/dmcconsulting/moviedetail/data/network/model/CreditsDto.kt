package br.com.dmcconsulting.moviedetail.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreditsDto(
    @SerialName("cast")
    val cast: List<CastDto>,

    @SerialName("crew")
    val crew: List<CrewDto>
)
