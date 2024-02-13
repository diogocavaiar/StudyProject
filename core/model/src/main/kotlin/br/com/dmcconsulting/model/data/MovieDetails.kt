package br.com.dmcconsulting.model.data

/**
 * Data class representing detailed information about a movie.
 *
 * @property title The title of the movie.
 * @property overview A brief overview or summary of the movie.
 * @property backdropPath The path to the backdrop image of the movie.
 * @property genres The list of genres associated with the movie.
 * @property posterPath The path to the poster image of the movie.
 * @property releaseDate The release date of the movie (nullable).
 * @property runtime The duration of the movie (nullable).
 * @property credits The credits information (cast and crew) for the movie.
 */
data class MovieDetails(
    val title: String,
    val overview: String,
    val backdropPath: String,
    val genres: List<Genre>,
    val posterPath: String,
    val releaseDate: String?,
    val runtime: String?,
    val credits: Credits
)

