package uk.gov.onelogin.criorchestrator.sdk.internal

import android.content.Context
import uk.gov.android.network.client.GenericHttpClient
import uk.gov.logging.api.analytics.logging.AnalyticsLogger
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

/**
 * Creates instance of [BaseCriOrchestratorComponent].
 *
 * @param authenticatedHttpClient The HTTP client to make all network calls.
 * @param analyticsLogger The analytics logger that will receive events from the SDK.
 * @param context Application context
 * @return An instance of [CriOrchestratorComponent]
 */
fun createCriOrchestratorComponent(
    authenticatedHttpClient: GenericHttpClient,
    analyticsLogger: AnalyticsLogger,
    context: Context,
): CriOrchestratorComponent =
    DaggerMergedBaseCriOrchestratorComponent.factory().create(
        authenticatedHttpClient = authenticatedHttpClient,
        analyticsLogger = analyticsLogger,
        context = context,
    )
