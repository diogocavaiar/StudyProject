package br.com.dmcconsulting.movie.presentation

import androidx.compose.runtime.Immutable
import br.com.dmcconsulting.common.mediatype.MediaType
import br.com.dmcconsulting.common.mvi.State
import br.com.dmcconsulting.model.data.Movie

/**
 * Immutable data class representing the state of the home UI.
 *
 * @property movies Map containing movies grouped by their media types.
 * @property loadStates Map containing load states for different media types.
 * @property error Throwable representing any error that occurred.
 */
@Immutable
data class HomeUiState(
    val movies: Map<MediaType.Movie, List<Movie>> = emptyMap(),
    val loadStates: Map<MediaType, Boolean> = emptyMap(),
    val error: Throwable? = null,
) : State {

    companion object {
        /**
         * Default instance of [HomeUiState] with initial load states set to true for all media types.
         */
        val default: HomeUiState = HomeUiState(
            loadStates = mapOf(
                MediaType.Movie.TOP_RATED to true,
                MediaType.Movie.NOW_PLAYING to true,
                MediaType.Movie.POPULAR to true,
                MediaType.Movie.UPCOMING to true
            )
        )
    }
}

