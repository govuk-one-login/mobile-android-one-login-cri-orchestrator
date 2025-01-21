package uk.gov.onelogin.criorchestrator.features.resume.internalapi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.squareup.anvil.annotations.ContributesTo
import uk.gov.onelogin.criorchestrator.libraries.di.ActivityScope
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope

interface ProveYourIdentityEntryPoints {
    @Composable
    fun ProveYourIdentityCard(modifier: Modifier)
}

@ActivityScope
@ContributesTo(CriOrchestratorScope::class)
interface ProveYourIdentityEntryPointsComponent {
    fun proveYourIdentityEntryPoints(): ProveYourIdentityEntryPoints
}
