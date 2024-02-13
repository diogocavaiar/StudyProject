package br.com.dmcconsulting.moviedetail.domain.model

/**
 * Represents a crew member associated with a movie.
 *
 * This data class encapsulates information about a crew member involved in the production of a movie,
 * including details such as their ID, name, job, and other relevant attributes.
 *
 * @property id Unique identifier for the crew member.
 * @property adult Indicates whether the crew member is an adult.
 * @property creditId Unique identifier for the credit associated with the crew member.
 * @property department The department or role of the crew member in the movie production.
 * @property gender Gender of the crew member.
 * @property job The specific job or role of the crew member in the movie production.
 * @property knownForDepartment The department the crew member is known for.
 * @property name The name of the crew member.
 * @property originalName The original name of the crew member.
 * @property popularity Popularity score of the crew member.
 * @property profilePath Path to the profile image of the crew member.
 */
data class CrewModel(
    val id: Int,
    val adult: Boolean,
    val creditId: String,
    val department: String,
    val gender: Int?,
    val job: String,
    val knownForDepartment: String,
    val name: String,
    val originalName: String,
    val popularity: Double,
    val profilePath: String?
)

