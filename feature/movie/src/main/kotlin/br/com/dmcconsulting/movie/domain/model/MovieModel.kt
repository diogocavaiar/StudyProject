package br.com.dmcconsulting.movie.domain.model

import kotlinx.datetime.LocalDate

/**
 * Represents basic information about a movie.
 *
 * This data class encapsulates essential details about a movie, including attributes such as
 * ID, title, overview, release date, and various other relevant information.
 *
 * @property id Unique identifier for the movie.
 * @property title Title of the movie.
 * @property releaseDate Release date of the movie.
 * @property posterPath Path to the poster image associated with the movie.
 */
data class MovieModel(
    val id: Int,
    val title: String,
    val releaseDate: LocalDate?,
    val posterPath: String,
)

