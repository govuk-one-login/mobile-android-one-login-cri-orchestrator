package uk.gov.onelogin.criorchestrator.sdk.publicapi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import uk.gov.android.network.client.GenericHttpClient
import uk.gov.onelogin.criorchestrator.sdk.internal.createCriOrchestratorComponent
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

@Composable
fun rememberCriOrchestrator(
    authenticatedHttpClient: GenericHttpClient,
): CriOrchestratorComponent {
    return remember {
        createCriOrchestratorComponent(
            authenticatedHttpClient = authenticatedHttpClient,
        )
    }
}
