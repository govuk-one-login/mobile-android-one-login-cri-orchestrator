package uk.gov.onelogin.criorchestrator.sdk.internal

import uk.gov.android.network.client.GenericHttpClient
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

fun createCriOrchestratorComponent(
    authenticatedHttpClient: GenericHttpClient,
): CriOrchestratorComponent {
    return DaggerMergedBaseCriOrchestratorComponent.factory().create(
        authenticatedHttpClient = authenticatedHttpClient,
    )
}
