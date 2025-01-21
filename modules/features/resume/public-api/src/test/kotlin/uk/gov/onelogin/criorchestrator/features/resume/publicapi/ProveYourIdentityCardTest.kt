package uk.gov.onelogin.criorchestrator.features.resume.publicapi

import androidx.compose.ui.Modifier
import app.cash.molecule.RecompositionMode
import app.cash.molecule.moleculeFlow
import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertInstanceOf
import uk.gov.android.network.api.ApiResponse
import uk.gov.android.network.client.StubHttpClient
import uk.gov.onelogin.criorchestrator.features.resume.internalapi.ProveYourIdentityEntryPointsComponent
import uk.gov.onelogin.criorchestrator.sdk.internal.createCriOrchestratorComponent

class ProveYourIdentityCardTest {
    private val component = createCriOrchestratorComponent(
        StubHttpClient(
            apiResponse = ApiResponse.Offline,
        ),
    )

    @Test
    fun `it returns a value`() = runTest {
        moleculeFlow(RecompositionMode.ContextClock) {
            ProveYourIdentityCard(
                component = component,
                modifier = Modifier,
            )
        }.test {
            assertInstanceOf<ProveYourIdentityEntryPointsComponent>(awaitItem())
            cancel()
        }
    }
}
