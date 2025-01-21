package uk.gov.onelogin.criorchestrator.sdk.internal

import uk.gov.android.network.client.GenericHttpClient
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

/**
 * Creates instance of [BaseCriOrchestratorComponent].
 *
 * @param authenticatedHttpClient The HTTP client to make all network calls.
 * @return An instance of [CriOrchestratorComponent]
 */
fun createCriOrchestratorComponent(
    authenticatedHttpClient: GenericHttpClient,
): CriOrchestratorComponent {
    return DaggerMergedBaseCriOrchestratorComponent.factory().create(
        authenticatedHttpClient = authenticatedHttpClient,
    )
}
