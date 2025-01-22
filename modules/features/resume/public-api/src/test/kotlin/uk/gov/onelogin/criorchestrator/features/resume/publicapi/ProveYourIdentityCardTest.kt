package uk.gov.onelogin.criorchestrator.features.resume.publicapi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cash.molecule.RecompositionMode
import app.cash.molecule.moleculeFlow
import app.cash.turbine.test
import dagger.Component
import dagger.Module
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertInstanceOf
import uk.gov.onelogin.criorchestrator.features.resume.internalapi.ProveYourIdentityEntryPoints
import uk.gov.onelogin.criorchestrator.features.resume.internalapi.ProveYourIdentityEntryPointsComponent
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

@Module
abstract class TestModule

@Component(modules = [TestModule::class])
interface TestProveYourIdentityCard

@Composable
fun mockCard(): TestProveYourIdentityCard {
    return DaggerTestProveYourIdentityCard.create()
}

class MockCriOrchestratorComponent: CriOrchestratorComponent, ProveYourIdentityEntryPointsComponent {
    class MockProveYourIdentityEntryPoints: ProveYourIdentityEntryPoints {
        @Composable
        override fun ProveYourIdentityCard(modifier: Modifier) {
            mockCard()
        }
    }

    override fun proveYourIdentityEntryPoints(): ProveYourIdentityEntryPoints {
        return MockProveYourIdentityEntryPoints()
    }
}

class ProveYourIdentityCardTest {
    @Test
    fun addition_isCorrect() = runTest {
        moleculeFlow(RecompositionMode.Immediate) {
            ProveYourIdentityCard(
                component = MockCriOrchestratorComponent(),
                modifier = Modifier
            )
        }.test {
            assertInstanceOf<TestProveYourIdentityCard>(awaitItem())
            cancel()
        }
    }
}
