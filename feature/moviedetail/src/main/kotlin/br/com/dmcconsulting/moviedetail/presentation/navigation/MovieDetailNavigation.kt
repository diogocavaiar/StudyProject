package br.com.dmcconsulting.moviedetail.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.dmcconsulting.moviedetail.presentation.DetailMovieScreen
import br.com.dmcconsulting.moviedetail.presentation.navigation.DetailMovie.withArgs
import br.com.dmcconsulting.navigation.route.Route

/**
 * Argument key for passing movie ID.
 */
private const val ARG_MOVIE_ID = "id"

/**
 * Route representing the detail movie screen.
 */
data object DetailMovie : Route {
    override val route: String
        get() = "detailMovie/{$ARG_MOVIE_ID}"

    /**
     * Constructs the route with the movie ID.
     *
     * @param id The movie ID to be included in the route.
     * @return The constructed route with the movie ID.
     */
    fun withArgs(id: String): String = route.replace("{$ARG_MOVIE_ID}", id)
}

/**
 * Navigates to the detail movie screen.
 *
 * @param movieId The ID of the movie to navigate to.
 * @param navOptions Navigation options.
 */
fun NavController.navigateToMovieDetail(movieId: Int, navOptions: NavOptions? = null) {
    this.navigate(
        route = withArgs(
            id = movieId.toString()
        ),
        navOptions = navOptions
    )
}

/**
 * Constructs the detail movie graph.
 *
 * @param onClickBackButton Callback for handling back button clicks.
 */
fun NavGraphBuilder.detailMovieGraph(
    onClickBackButton: () -> Unit,
) {
    composable(
        route = DetailMovie.route,
        arguments = listOf(
            navArgument(ARG_MOVIE_ID) { type = NavType.StringType },
        ),
    )
    {
        DetailMovieScreen(
            onClickBackButton = onClickBackButton,
        )
    }
}
