package br.com.dmcconsulting.movie.presentation

import androidx.lifecycle.viewModelScope
import br.com.dmcconsulting.common.di.IoDispatcher
import br.com.dmcconsulting.common.mediatype.MediaType
import br.com.dmcconsulting.common.result.handle
import br.com.dmcconsulting.common.viewmodel.ViewModelState
import br.com.dmcconsulting.model.data.Movie
import br.com.dmcconsulting.movie.domain.model.MovieModel
import br.com.dmcconsulting.movie.domain.usecase.GetMoviesUseCase
import br.com.dmcconsulting.movie.presentation.mapper.asMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

/**
 * ViewModel class for managing the state of the movie screen.
 *
 * @param getMoviesUseCase Use case for fetching movies.
 * @param ioDispatcher CoroutineDispatcher for performing IO operations.
 */
@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModelState<HomeUiState, MovieIntent>(HomeUiState.default) {

    init {
        // Initial intent to load movie content
        intent(MovieIntent.LoadContent)
    }

    /**
     * Handles incoming intents.
     *
     * @param intent The incoming movie intent.
     */
    override fun intent(intent: MovieIntent) {
        when (intent) {
            is MovieIntent.LoadContent -> loadContent()
            is MovieIntent.Retry -> retry()
        }
    }

    /**
     * Loads movie content.
     */
    private fun loadContent() {
        // List of movie media types to load
        val movieMediaTypes = listOf(
            MediaType.Movie.UPCOMING,
            MediaType.Movie.TOP_RATED,
            MediaType.Movie.POPULAR,
            MediaType.Movie.NOW_PLAYING
        )
        // Load movies for each media type
        movieMediaTypes.forEach(::loadMovies)
    }

    /**
     * Retries loading movie content.
     */
    private fun retry() {
        // Clear any existing error and refresh content
        onClearError()
        onRefresh()
    }

    /**
     * Clears the error state.
     */
    private fun onClearError() = setState {
        copy(error = null)
    }

    /**
     * Refreshes the movie content.
     */
    private fun onRefresh() {
        // Cancel ongoing operations and reload content
        viewModelScope.coroutineContext.cancelChildren()
        loadContent()
    }

    /**
     * Loads movies for a given media type.
     *
     * @param mediaType The media type for which movies are to be loaded.
     */
    private fun loadMovies(mediaType: MediaType.Movie) = viewModelScope.launch(ioDispatcher) {
        getMoviesUseCase(mediaType).handle {
            onLoading {
                // Update state while loading
                setState {
                    copy(
                        loadStates = this.loadStates.plus(mediaType to true),
                        error = null
                    )
                }
            }
            onSuccess { movies ->
                // Update state on successful data retrieval
                setState {
                    copy(
                        movies = this.movies.plus(mediaType to movies.map(MovieModel::asMovie)),
                        loadStates = this.loadStates.plus(mediaType to false),
                        error = null
                    )
                }
            }
            onFailure { error -> handleFailure(error = error, mediaType = mediaType) }
        }
    }

    /**
     * Handles failure during movie data retrieval.
     *
     * @param error The error occurred.
     * @param mediaType The media type for which the error occurred.
     */
    private fun handleFailure(error: Throwable, mediaType: MediaType) =
        setState {
            copy(
                error = error,
                loadStates = this.loadStates.plus(mediaType to false)
            )
        }
}

