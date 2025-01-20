package uk.gov.onelogin.criorchestrator.features.resume.publicapi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.gov.onelogin.criorchestrator.features.resume.internalapi.ProveIdentityEntryPointsComponent
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

@Composable
fun ProveIdentityCard(
    component: CriOrchestratorComponent,
    modifier: Modifier,
) {
    (component as ProveIdentityEntryPointsComponent).proveIdentityEntryPoints().ProveIdentityCard(
        modifier = modifier,
    )
}
