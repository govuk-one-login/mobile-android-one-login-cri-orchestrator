package uk.gov.onelogin.criorchestrator.sdk.internal

import uk.gov.onelogin.criorchestrator.sdk.sharedapi.AuthenticatedHttpClient
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

fun createCriOrchestratorComponent(
    authenticatedHttpClient: AuthenticatedHttpClient,
): CriOrchestratorComponent {
    TODO()
//    return DaggerMergedBaseCriOrchestratorComponent.factory().create(
//        authenticatedHttpClient = authenticatedHttpClient,
//    )
}
