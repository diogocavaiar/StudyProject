package br.com.dmcconsulting.moviedetail.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenreDto(
    @SerialName("name")
    val name: String
)
