package br.com.dmcconsulting.moviedetail.data.network.model

import br.com.dmcconsulting.framework.serializer.LocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsDto(
    @SerialName("backdrop_path")
    val backdropPath: String?,

    @SerialName("genres")
    val genres: List<GenreDto>,

    @SerialName("overview")
    val overview: String,

    @SerialName("poster_path")
    val posterPath: String?,

    @Serializable(LocalDateSerializer::class)
    @SerialName("release_date")
    val releaseDate: LocalDate?,

    @SerialName("runtime")
    val runtime: Int?,

    @SerialName("title")
    val title: String,

    @SerialName("credits")
    val credits: CreditsDto
)
