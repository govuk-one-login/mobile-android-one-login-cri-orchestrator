package uk.gov.onelogin.criorchestrator.features.resume.publicapi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cash.molecule.RecompositionMode
import app.cash.molecule.moleculeFlow
import app.cash.turbine.test
import dagger.Binds
import dagger.Component
import dagger.Module
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertInstanceOf
import uk.gov.onelogin.criorchestrator.features.resume.internal.ProveYourIdentityEntryPointsImpl
import uk.gov.onelogin.criorchestrator.features.resume.internalapi.ProveYourIdentityEntryPoints
import uk.gov.onelogin.criorchestrator.features.resume.internalapi.ProveYourIdentityEntryPointsComponent
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

@Module
abstract class TestModule {
    @Binds
    abstract fun bindCriOrchestratorComponent(
        mockComponent: MockCriOrchestratorComponent
    ): TestCriOrchestratorComponent
}

@Component(modules = [TestModule::class])
interface TestCriOrchestratorComponent: CriOrchestratorComponent


class MockCriOrchestratorComponent:
    TestCriOrchestratorComponent,
    ProveYourIdentityEntryPointsComponent {
    override fun proveYourIdentityEntryPoints(): ProveYourIdentityEntryPoints {
        TODO("Not yet implemented")
    }
}



class ProveYourIdentityCardTest {
    @Test
    fun addition_isCorrect() = runTest {
        moleculeFlow(RecompositionMode.Immediate) {
            ProveYourIdentityCard(
                component = DaggerTestCriOrchestratorComponent.create(),
                modifier = Modifier
            )
        }.test {
            assertInstanceOf<ProveYourIdentityEntryPointsImpl>(awaitItem())
            cancel()
        }
    }
}
