package uk.gov.onelogin.criorchestrator.features.resume.internal

import androidx.compose.ui.Modifier
import app.cash.molecule.RecompositionMode
import app.cash.molecule.moleculeFlow
import app.cash.turbine.test
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class ProveYourIdentityEntryPointsImplTest {
    @Test
    fun `it returns a value`() = runTest {
        moleculeFlow(RecompositionMode.Immediate) {
            ProveYourIdentityEntryPointsImpl().ProveYourIdentityCard(
                modifier = Modifier
            )
        }.test {
            // todo: what is the right assert here?
            // assertInstanceOf<ProveYourIdentityUiCard>(awaitItem())
            cancel()
        }
    }
}
