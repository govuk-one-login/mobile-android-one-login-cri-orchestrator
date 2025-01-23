package uk.gov.onelogin.criorchestrator.sdk.publicapi

import app.cash.molecule.RecompositionMode
import app.cash.molecule.moleculeFlow
import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertInstanceOf
import uk.gov.android.network.api.ApiResponse
import uk.gov.android.network.client.StubHttpClient
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

class RememberCriOrchestratorKtTest {

    private val httpClient = StubHttpClient(
        apiResponse = ApiResponse.Offline,
    )

    @Test
    fun `it returns a value`() = runTest {
        moleculeFlow(RecompositionMode.Immediate) {
            rememberCriOrchestrator(
                authenticatedHttpClient = httpClient,
            )
        }.test {
            assertInstanceOf<CriOrchestratorComponent>(awaitItem())
            cancel()
        }
    }
}
