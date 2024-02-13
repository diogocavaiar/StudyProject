package br.com.dmcconsulting.studyproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import br.com.dmcconsulting.movie.presentation.navigation.movieGraph
import br.com.dmcconsulting.moviedetail.presentation.navigation.detailMovieGraph
import br.com.dmcconsulting.moviedetail.presentation.navigation.navigateToMovieDetail
import br.com.dmcconsulting.navigation.route.Route

/**
 * Composable function responsible for managing the navigation graph of the main screen.
 *
 * @param navController The navigation controller responsible for managing navigation within this graph.
 * @param startDestination The initial destination of the navigation graph.
 * @param onBackClick Callback function to handle back navigation.
 */
@Composable
fun MainScreenNavGraph(
    navController: NavHostController,
    startDestination: Route,
    onBackClick: () -> Unit,
) {
    NavHost(
        navController = navController,
        route = "main_navigation",
        startDestination = startDestination.route,
    ) {
        movieGraph(
            navigateToMovieDetail = navController::navigateToMovieDetail
        )
        detailMovieGraph(
            onClickBackButton = onBackClick
        )
    }
}

