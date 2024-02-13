package br.com.dmcconsulting.movie.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.dmcconsulting.movie.presentation.MovieScreen
import br.com.dmcconsulting.navigation.route.Route

/**
 * Represents a route for navigating to the movie screen.
 */
data object Movie : Route {
    override val route: String
        get() = "movie"
}

/**
 * Sets up navigation for the movie screen in a Jetpack Compose navigation graph.
 * @param navigateToMovieDetail Lambda function to navigate to the movie detail screen.
 */
fun NavGraphBuilder.movieGraph(
    navigateToMovieDetail: (Int) -> Unit
) {
    /**
     * Creates a composable destination for the movie screen.
     */
    composable(
        route = Movie.route
    ) {
        MovieScreen(
            onClickCard = { id ->
                navigateToMovieDetail(id)
            },
        )
    }
}
