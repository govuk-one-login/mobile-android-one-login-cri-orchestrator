package uk.gov.onelogin.criorchestrator.libraries.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

/**
 * TODO
 */
interface NavGraphProvider {
    fun NavGraphBuilder.contributeToGraph(navController: NavController)
}
