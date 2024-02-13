package br.com.dmcconsulting.model.data

/**
 * Data class representing a movie.
 *
 * @property id The unique identifier of the movie.
 * @property title The title of the movie.
 * @property releaseDate The release date of the movie.
 * @property posterPath The path to the poster image of the movie.
 */
data class Movie(
    val id: Int,
    val title: String,
    val releaseDate: String,
    val posterPath: String
)

