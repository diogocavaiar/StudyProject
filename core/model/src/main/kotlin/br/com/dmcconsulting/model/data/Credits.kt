package br.com.dmcconsulting.model.data

/**
 * Data class representing credits information for a movie or TV show.
 *
 * @property cast List of cast members.
 * @property crew List of crew members.
 */
data class Credits(
    val cast: List<Cast>,
    val crew: List<Crew>
)

/**
 * Data class representing a cast member.
 *
 * @property id The unique identifier of the cast member.
 * @property name The name of the cast member.
 * @property character The character played by the cast member.
 * @property profilePath The path to the profile image of the cast member.
 */
data class Cast(
    val id: Int,
    val name: String,
    val character: String,
    val profilePath: String?
)

/**
 * Data class representing a crew member.
 *
 * @property id The unique identifier of the crew member.
 * @property name The name of the crew member.
 * @property job The role/job of the crew member.
 * @property profilePath The path to the profile image of the crew member.
 */
data class Crew(
    val id: Int,
    val name: String,
    val job: String,
    val profilePath: String?
)

