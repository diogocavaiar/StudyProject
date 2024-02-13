package br.com.dmcconsulting.studyproject.features.home.presentation

import androidx.compose.runtime.Composable
import br.com.dmcconsulting.studyproject.navigation.MainScreenNavGraph
import br.com.dmcconsulting.studyproject.ui.DmcAppState
import br.com.dmcconsulting.studyproject.ui.rememberDmcAppState

/**
 * Composable function responsible for displaying the main screen of the application.
 *
 * @param appState The current application state, defaults to [DmcAppState] obtained using [rememberDmcAppState].
 */
@Composable
fun MainScreen(
    appState: DmcAppState = rememberDmcAppState(),
) {
    MainScreenNavGraph(
        navController = appState.navController,
        startDestination = appState.startDestination,
        onBackClick = appState::onBackClick,
    )
}

