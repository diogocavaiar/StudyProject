package br.com.dmcconsulting.moviedetail.domain.model

/**
 * Represents a cast member in a movie.
 *
 *
 * @property id The unique identifier for the cast member.
 * @property name The name of the cast member.
 * @property adult Indicates whether the cast member is an adult.
 * @property castId The identifier associated with the cast.
 * @property character The character played by the cast member.
 * @property creditId The unique identifier for the credit associated with the cast member.
 * @property gender The gender of the cast member.
 * @property knownForDepartment The department for which the cast member is known.
 * @property order The order in which the cast member appears.
 * @property originalName The original name of the cast member.
 * @property popularity The popularity score of the cast member.
 * @property profilePath The path to the profile image of the cast member, or null if not available.
 */
data class CastModel(
    val id: Int,
    val name: String,
    val adult: Boolean,
    val castId: Int?,
    val character: String,
    val creditId: String,
    val gender: Int?,
    val knownForDepartment: String,
    val order: Int,
    val originalName: String,
    val popularity: Double,
    val profilePath: String?
)

