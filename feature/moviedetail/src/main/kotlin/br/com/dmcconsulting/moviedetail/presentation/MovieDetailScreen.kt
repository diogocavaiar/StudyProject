package br.com.dmcconsulting.moviedetail.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.dmcconsulting.designsystem.components.AlertDialogWithConfirmAndDismissButton
import br.com.dmcconsulting.designsystem.components.ErrorView
import br.com.dmcconsulting.model.data.MovieDetails
import br.com.dmcconsulting.ui.ContentDetail
import br.com.dmcconsulting.ui.analytics.TrackScreenViewEvent

/**
 * Composable function for displaying the detail movie screen.
 *
 * @param onClickBackButton Callback function to handle clicks on the back button.
 * @param viewModel MovieDetailViewModel instance for managing the detail movie screen state.
 */
@Composable
fun DetailMovieScreen(
    onClickBackButton: () -> Unit,
    viewModel: MovieDetailViewModel = hiltViewModel()
) {
    // Track screen view event
    TrackScreenViewEvent(screenName = "MovieDetail: ${viewModel.movieId}")

    // Collecting the detail movie state using StateFlow and Lifecycle
    val state by viewModel.state.collectAsStateWithLifecycle()

    // Showing a dialog if required
    if (state.isShowDialogSaveFavorite) {
        AlertDialogWithConfirmAndDismissButton(
            onDismissRequest = viewModel::onDismissDialogFavorite,
            onConfirmation = viewModel::onDismissDialogFavorite,
            dialogTitle = "Info",
            dialogText = "This feature is under construction",
            icon = Icons.Default.Info,
            contentDescriptionIcon = "Information Icon"
        )
    }

    // Displaying the content of the detail movie screen
    DetailMovieContent(
        state,
        viewModel::saveFavorite,
        viewModel::retry,
        onClickBackButton,
    )
}

/**
 * Composable function for displaying the content of the detail movie screen.
 *
 * @param value The state of the detail movie screen.
 * @param onClickFavorite Callback function to handle clicks on the favorite button.
 * @param onRetry Callback function to handle retry action.
 * @param onClickBackButton Callback function to handle clicks on the back button.
 */
@Composable
private fun DetailMovieContent(
    value: MovieDetailState,
    onClickFavorite: (MovieDetails) -> Unit,
    onRetry: () -> Unit,
    onClickBackButton: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Displaying detail movie content based on state
        Detail(value, onClickFavorite, onRetry, onClickBackButton)
    }
}

/**
 * Internal composable function for displaying detail movie content.
 *
 * @param value The state of the detail movie screen.
 * @param onClickFavorite Callback function to handle clicks on the favorite button.
 * @param onRetry Callback function to handle retry action.
 * @param onClickBackButton Callback function to handle clicks on the back button.
 */
@Composable
private fun BoxScope.Detail(
    value: MovieDetailState,
    onClickFavorite: (MovieDetails) -> Unit,
    onRetry: () -> Unit,
    onClickBackButton: () -> Unit,
) {
    with(value) {
        when {
            isLoading -> CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )

            error != null -> ErrorView(
                errorText = error.message.orEmpty(),
                modifier = Modifier.fillMaxSize(),
                onRetry = onRetry
            )

            data != null -> ContentDetail(
                data = data,
                onClickBackButton = onClickBackButton,
                onClickFavorite = onClickFavorite
            )
        }
    }
}

