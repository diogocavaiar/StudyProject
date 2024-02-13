package br.com.dmcconsulting.moviedetail.presentation

import androidx.compose.runtime.Stable
import br.com.dmcconsulting.common.mvi.State
import br.com.dmcconsulting.model.data.MovieDetails

/**
 * Immutable data class representing the state of the detail movie screen.
 *
 * @property isLoading Indicates whether the screen is in a loading state.
 * @property data The details of the movie being displayed.
 * @property error Any error that occurred during data retrieval.
 * @property isShowDialogSaveFavorite Indicates whether to show a dialog for saving the movie as a favorite.
 */
@Stable
data class MovieDetailState(
    val isLoading: Boolean = true,
    val data: MovieDetails?,
    val error: Throwable? = null,
    val isShowDialogSaveFavorite: Boolean = false
) : State {

    companion object {
        /**
         * Creates a loading state.
         *
         * @return A loading state.
         */
        fun loading(): MovieDetailState = MovieDetailState(
            isLoading = false,
            data = null
        )
    }
}
