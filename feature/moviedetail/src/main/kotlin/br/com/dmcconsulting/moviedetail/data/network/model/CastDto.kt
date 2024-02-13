package br.com.dmcconsulting.moviedetail.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CastDto(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("adult")
    val adult: Boolean,

    @SerialName("cast_id")
    val castId: Int?,

    @SerialName("character")
    val character: String,

    @SerialName("credit_id")
    val creditId: String,

    @SerialName("gender")
    val gender: Int?,

    @SerialName("known_for_department")
    val knownForDepartment: String,

    @SerialName("order")
    val order: Int,

    @SerialName("original_name")
    val originalName: String,

    @SerialName("popularity")
    val popularity: Double,

    @SerialName("profile_path")
    val profilePath: String?
)
