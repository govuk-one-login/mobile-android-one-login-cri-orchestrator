package uk.gov.onelogin.criorchestrator.sdk.publicApi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberCriOrchestrator(
    criOrchestratorSingleton: CriOrchestratorSingleton,
    authenticatedHttpClient: AuthenticatedHttpClient,
): CriOrchestratorComponent {
    val activity = findActivity()
    return remember {
        createCriOrchestratorComponent(
            criOrchestratorSingleton = criOrchestratorSingleton,
            authenticatedHttpClient = authenticatedHttpClient,
            activity = activity,
        )
    }
}
