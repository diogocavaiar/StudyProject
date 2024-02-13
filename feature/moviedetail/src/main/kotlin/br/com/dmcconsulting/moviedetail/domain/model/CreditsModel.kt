package br.com.dmcconsulting.moviedetail.domain.model

/**
 * Represents the credits associated with a movie, including both cast and crew.
 *
 * This data class encapsulates information about the credits of a movie, including lists of
 * cast members and crew members involved in its production.
 *
 * @property cast List of cast members associated with the movie.
 * @property crew List of crew members associated with the movie.
 */
data class CreditsModel(
    val cast: List<CastModel>,
    val crew: List<CrewModel>
)

