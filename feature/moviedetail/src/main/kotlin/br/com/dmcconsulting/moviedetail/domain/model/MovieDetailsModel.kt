package br.com.dmcconsulting.moviedetail.domain.model

/**
 * Represents detailed information about a movie.
 *
 * This data class encapsulates comprehensive details about a movie, including attributes such as
 * ID, title, budget, genres, release date, and various other relevant information.
 *
 * @property backdropPath Path to the backdrop image associated with the movie.
 * @property genres List of genres associated with the movie.
 * @property overview Brief overview or summary of the movie.
 * @property posterPath Path to the poster image associated with the movie.
 * @property releaseDate Release date of the movie.
 * @property runtime Duration of the movie.
 * @property title Title of the movie.
 * @property credits Credits information including cast and crew.
 */
data class MovieDetailsModel(
    val backdropPath: String,
    val genres: List<GenreModel>,
    val overview: String,
    val posterPath: String,
    val releaseDate: String?,
    val runtime: String?,
    val title: String,
    val credits: CreditsModel,
)
