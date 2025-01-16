package uk.gov.onelogin.criorchestrator.sdk.publicapi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import uk.gov.onelogin.criorchestrator.sdk.internal.createCriOrchestratorComponent
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.AuthenticatedHttpClient
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

@Composable
fun rememberCriOrchestrator(
    authenticatedHttpClient: AuthenticatedHttpClient,
): CriOrchestratorComponent {
    return remember {
        createCriOrchestratorComponent(
            authenticatedHttpClient = authenticatedHttpClient,
        )
    }
}