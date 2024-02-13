package br.com.dmcconsulting.navigation.extension

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

/**
 * Extension function for [NavHostController] to navigate to a destination in the same graph
 * with the single top launch mode.
 *
 * This function is useful for navigating to a destination while ensuring that only one instance
 * of the destination is present on the back stack, and it is reused if already on top.
 *
 * @param route The route of the destination to navigate to.
 */
fun NavHostController.navigateSingleTopToGraph(route: String) =
    navigate(route) {
        // Pop up to the start destination of the graph
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        // Restore state if the destination is already on the back stack
        restoreState = true
    }
