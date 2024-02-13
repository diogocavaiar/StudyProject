package br.com.dmcconsulting.movie.presentation

import br.com.dmcconsulting.common.mvi.Intent

/**
 * Sealed interface representing intents related to movie actions.
 */
sealed interface MovieIntent : Intent {

    /**
     * Intent to load movie content.
     */
    data object LoadContent : MovieIntent

    /**
     * Intent to retry a movie action.
     */
    data object Retry : MovieIntent
}
