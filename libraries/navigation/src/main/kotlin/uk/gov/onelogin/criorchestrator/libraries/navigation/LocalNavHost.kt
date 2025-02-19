package uk.gov.onelogin.criorchestrator.libraries.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotlinx.collections.immutable.ImmutableSet

/**
 * TODO
 */
@Composable
fun LocalNavHost(
    navGraphProviders: ImmutableSet<NavGraphProvider>,
    startDestination: NavigationDestination,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        for (navGraphProvider in navGraphProviders) {
            with(navGraphProvider) {
                contributeToGraph(navController)
            }
        }
    }
}
