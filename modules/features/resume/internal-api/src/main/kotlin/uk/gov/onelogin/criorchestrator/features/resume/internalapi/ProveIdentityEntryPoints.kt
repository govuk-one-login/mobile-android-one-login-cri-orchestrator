package uk.gov.onelogin.criorchestrator.features.resume.internalapi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.squareup.anvil.annotations.ContributesTo
import uk.gov.onelogin.criorchestrator.libraries.di.ActivityScope
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope

interface ProveIdentityEntryPoints {
    @Composable
    fun ProveIdentityCard(modifier: Modifier)
}

@ActivityScope
@ContributesTo(CriOrchestratorScope::class)
interface ProveIdentityEntryPointsComponent {
    fun proveIdentityEntryPoints(): ProveIdentityEntryPoints
}
