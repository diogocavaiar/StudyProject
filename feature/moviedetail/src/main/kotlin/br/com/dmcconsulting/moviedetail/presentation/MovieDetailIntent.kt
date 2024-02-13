package br.com.dmcconsulting.moviedetail.presentation

import br.com.dmcconsulting.common.mvi.Intent
import br.com.dmcconsulting.model.data.MovieDetails

/**
 * Sealed class representing intents related to movie detail actions.
 */
sealed class MovieDetailIntent : Intent {

    /**
     * Intent to get movie details by ID.
     */
    data object GetMovieDetailById : MovieDetailIntent()

    /**
     * Intent to retry a movie detail action.
     */
    data object Retry : MovieDetailIntent()

    /**
     * Intent to save a movie as favorite.
     *
     * @param movieDetails The details of the movie to be saved as favorite.
     */
    data class SaveFavoriteMovie(val movieDetails: MovieDetails) : MovieDetailIntent()
}

