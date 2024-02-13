package br.com.dmcconsulting.moviedetail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import br.com.dmcconsulting.common.di.IoDispatcher
import br.com.dmcconsulting.common.result.handle
import br.com.dmcconsulting.common.viewmodel.ViewModelState
import br.com.dmcconsulting.model.data.MovieDetails
import br.com.dmcconsulting.moviedetail.domain.usecase.GetMovieDetailByIdUseCase
import br.com.dmcconsulting.moviedetail.presentation.mapper.asMovieDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

/**
 * ViewModel class for managing the state of the detail movie screen.
 *
 * @param savedStateHandle SavedStateHandle for accessing saved state data.
 * @param getMovieDetailByIdUseCase Use case for fetching movie details by ID.
 * @param ioDispatcher CoroutineDispatcher for performing IO operations.
 */
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovieDetailByIdUseCase: GetMovieDetailByIdUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModelState<MovieDetailState, MovieDetailIntent>(MovieDetailState.loading()) {

    /**
     * ID of the movie.
     */
    val movieId: String? = savedStateHandle.get<String>("id")

    init {
        // Initial intent to fetch movie details by ID
        intent(MovieDetailIntent.GetMovieDetailById)
    }

    /**
     * Handles incoming intents.
     *
     * @param intent The incoming movie detail intent.
     */
    override fun intent(intent: MovieDetailIntent) {
        when (intent) {
            is MovieDetailIntent.GetMovieDetailById -> fetchDetailById()
            is MovieDetailIntent.Retry -> fetchDetailById()
            is MovieDetailIntent.SaveFavoriteMovie -> saveFavorite()
        }
    }

    /**
     * Retries fetching movie details.
     */
    fun retry() {
        intent(MovieDetailIntent.Retry)
    }

    /**
     * Saves the movie as favorite.
     *
     * @param movieDetails The details of the movie to be saved as favorite.
     */
    fun saveFavorite(movieDetails: MovieDetails) {
        intent(MovieDetailIntent.SaveFavoriteMovie(movieDetails))
    }

    /**
     * Dismisses the dialog for saving favorite movie.
     */
    fun onDismissDialogFavorite() {
        setState {
            copy(isShowDialogSaveFavorite = false)
        }
    }

    /**
     * Shows the dialog for saving favorite movie.
     */
    private fun saveFavorite() {
        setState {
            copy(isShowDialogSaveFavorite = true)
        }
    }

    /**
     * Fetches movie details by ID.
     */
    private fun fetchDetailById() = viewModelScope.launch(ioDispatcher) {
        getMovieDetailByIdUseCase(movieId).handle {
            onLoading { movie ->
                setState {
                    copy(data = movie?.asMovieDetails(), isLoading = true)
                }
            }
            onSuccess { movie ->
                setState {
                    copy(data = movie?.asMovieDetails(), isLoading = false)
                }
            }
            onFailure(::handleFailure)
        }
    }

    /**
     * Handles failure during fetching movie details.
     *
     * @param error The error occurred.
     */
    private fun handleFailure(error: Throwable) {
        setState {
            copy(
                error = error,
                isLoading = false
            )
        }
    }
}

