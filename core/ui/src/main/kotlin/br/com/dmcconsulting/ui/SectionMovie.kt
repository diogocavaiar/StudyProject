package br.com.dmcconsulting.ui

import TitleLargeText
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import br.com.dmcconsulting.designsystem.theme.DmcTheme
import br.com.dmcconsulting.model.data.Movie

/**
 * Composable function for displaying a section of movies.
 *
 * @param idTitle The string resource ID representing the title of the section.
 * @param isLoading Indicates whether the section is in a loading state.
 * @param movies The list of movies to display in the section.
 * @param onClickCard Callback for handling the click event on a movie card.
 */
@Composable
fun SectionMovie(
    @StringRes idTitle: Int,
    isLoading: Boolean?,
    movies: List<Movie>?,
    onClickCard: (Int) -> Unit
) {
    val title = stringResource(id = idTitle)
    TitleLargeText(
        text = title,
        modifier = Modifier.padding(start = DmcTheme.spacing.medium)
    )
    LazyRow(
        modifier = Modifier
            .testTag("SectionMovie_${title}")
    ) {
        contentItemMovie(isLoading, movies, onClickCard)
    }
}

/**
 * Composable function for rendering a movie item within a section.
 *
 * @param item The [Movie] object representing the movie to display.
 * @param onClickCard Callback for handling the click event on the movie card.
 */
@Composable
private fun SectionMovieItem(
    item: Movie,
    onClickCard: (Int) -> Unit
) {
    MovieCard(
        item.posterPath,
        item.title,
        item.releaseDate,
        item.id,
        onClickCard,
        Modifier.padding(start = DmcTheme.spacing.medium)
    )
}

/**
 * LazyListScope extension function for rendering movie items within a LazyRow.
 *
 * @param isLoading Indicates whether the section is in a loading state.
 * @param movies The list of movies to display in the section.
 * @param onClickCard Callback for handling the click event on a movie card.
 */
private fun LazyListScope.contentItemMovie(
    isLoading: Boolean?,
    movies: List<Movie>?,
    onClickCard: (Int) -> Unit
) {
    if (isLoading == true) {
        items(count = 5, itemContent = {
            ShimmerMovieCard()
        })
    } else {
        items(
            items = movies.orEmpty(),
            key = { it.id },
            itemContent = { item ->
                SectionMovieItem(item, onClickCard)
            }
        )
    }
}
