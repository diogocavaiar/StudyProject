package br.com.dmcconsulting.movie.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.dmcconsulting.common.mediatype.MediaType
import br.com.dmcconsulting.designsystem.components.ErrorView
import br.com.dmcconsulting.designsystem.theme.DmcTheme
import br.com.dmcconsulting.ui.R
import br.com.dmcconsulting.ui.SectionMovie
import br.com.dmcconsulting.ui.analytics.TrackScreenViewEvent

/**
 * Composable function for displaying the movie screen.
 *
 * @param onClickCard Callback function to handle clicks on movie cards.
 * @param modifier Modifier for adjusting the layout of the screen.
 * @param viewModel MovieViewModel instance for managing the movie screen state.
 */
@Composable
fun MovieScreen(
    onClickCard: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MovieViewModel = hiltViewModel()
) {
    // Collecting the movie state using StateFlow and Lifecycle
    val movieState by viewModel.state.collectAsStateWithLifecycle()

    // Tracking screen view event
    TrackScreenViewEvent(screenName = "MovieScreen")

    // Checking for errors in movie state
    if (movieState.error != null) {
        // Displaying error view if error is present
        ErrorView(
            modifier = Modifier.fillMaxSize(),
            errorText = movieState.error!!.message.orEmpty(),
            onRetry = {
                // Sending Retry intent to the view model
                viewModel.intent(MovieIntent.Retry)
            }
        )
    } else {
        // Displaying the movie content if no errors
        Column(
            modifier = modifier
                .fillMaxHeight()
                .windowInsetsPadding(WindowInsets.systemBars)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(DmcTheme.spacing.small),
        ) {
            // Displaying sections for different categories of movies
            SectionMovie(
                R.string.category_movie_top_rated,
                movieState.loadStates[MediaType.Movie.TOP_RATED],
                movieState.movies[MediaType.Movie.TOP_RATED],
                onClickCard
            )
            SectionMovie(
                R.string.category_movie_popular,
                movieState.loadStates[MediaType.Movie.POPULAR],
                movieState.movies[MediaType.Movie.POPULAR],
                onClickCard
            )
            SectionMovie(
                R.string.category_movie_now_playing,
                movieState.loadStates[MediaType.Movie.NOW_PLAYING],
                movieState.movies[MediaType.Movie.NOW_PLAYING],
                onClickCard
            )
            SectionMovie(
                R.string.category_movie_upcoming,
                movieState.loadStates[MediaType.Movie.UPCOMING],
                movieState.movies[MediaType.Movie.UPCOMING],
                onClickCard
            )
        }
    }
}


