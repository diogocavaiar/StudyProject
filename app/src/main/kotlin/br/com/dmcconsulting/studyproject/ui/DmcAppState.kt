package br.com.dmcconsulting.studyproject.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.dmcconsulting.movie.presentation.navigation.Movie
import br.com.dmcconsulting.navigation.route.Route
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope

/**
 * Composable function responsible for remembering the application state for the Digital Movie Collection (DMC) app.
 *
 * @param systemUiController The system UI controller responsible for managing system UI visibility.
 * @param coroutineScope The coroutine scope used for managing coroutines within the application.
 * @param navController The navigation controller responsible for managing navigation within the app.
 * @param startDestination The initial destination of the navigation graph.
 * @return The remembered [DmcAppState] instance.
 */
@Composable
fun rememberDmcAppState(
    systemUiController: SystemUiController = rememberSystemUiController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
    startDestination: Route = Movie
): DmcAppState = remember(
    systemUiController,
    coroutineScope,
    navController,
    startDestination
) {
    DmcAppState(
        systemUiController = systemUiController,
        coroutineScope = coroutineScope,
        navController = navController,
        startDestination = startDestination
    )
}


/**
 * Immutable class representing the state of the Digital Movie Collection (DMC) app.
 *
 * @property systemUiController The system UI controller responsible for managing system UI visibility.
 * @property coroutineScope The coroutine scope used for managing coroutines within the application.
 * @property navController The navigation controller responsible for managing navigation within the app.
 * @property startDestination The initial destination of the navigation graph.
 */
@Stable
class DmcAppState(
    val systemUiController: SystemUiController,
    val coroutineScope: CoroutineScope,
    val navController: NavHostController,
    val startDestination: Route
) {
    /**
     * Function to handle the back button click event by popping the back stack of the navigation controller.
     */
    fun onBackClick() = navController.popBackStack()
}
