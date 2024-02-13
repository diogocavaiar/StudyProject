package br.com.dmcconsulting.moviedetail.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CrewDto(
    @SerialName("id")
    val id: Int,

    @SerialName("adult")
    val adult: Boolean,

    @SerialName("credit_id")
    val creditId: String,

    @SerialName("department")
    val department: String,

    @SerialName("gender")
    val gender: Int?,

    @SerialName("job")
    val job: String,

    @SerialName("known_for_department")
    val knownForDepartment: String,

    @SerialName("name")
    val name: String,

    @SerialName("original_name")
    val originalName: String,

    @SerialName("popularity")
    val popularity: Double,

    @SerialName("profile_path")
    val profilePath: String?
)
