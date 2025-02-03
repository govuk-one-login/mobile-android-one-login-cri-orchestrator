package uk.gov.onelogin.criorchestrator.features.resume.publicapi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.gov.onelogin.criorchestrator.features.resume.internalapi.ProveYourIdentityEntryPointsComponent
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

@Composable
fun ProveYourIdentityCard(
    component: CriOrchestratorComponent,
    modifier: Modifier = Modifier,
) {
    (component as ProveYourIdentityEntryPointsComponent).proveYourIdentityEntryPoints().ProveYourIdentityCard(
        modifier = modifier,
    )
}
