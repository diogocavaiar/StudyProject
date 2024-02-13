package br.com.dmcconsulting.movie.data.network.model

import br.com.dmcconsulting.framework.serializer.LocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("overview")
    val overview: String,

    @SerialName("popularity")
    val popularity: Double,

    @Serializable(LocalDateSerializer::class)
    @SerialName("release_date")
    val releaseDate: LocalDate?,

    @SerialName("adult")
    val adult: Boolean,

    @SerialName("genre_ids")
    val genreIds: List<Int>,

    @SerialName("original_title")
    val originalTitle: String,

    @SerialName("original_language")
    val originalLanguage: String,

    @SerialName("vote_average")
    val voteAverage: Double,

    @SerialName("vote_count")
    val voteCount: Int,

    @SerialName("poster_path")
    val posterPath: String?,

    @SerialName("backdrop_path")
    val backdropPath: String?,

    @SerialName("video")
    val video: Boolean
)
