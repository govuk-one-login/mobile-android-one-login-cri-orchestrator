package uk.gov.onelogin.criorchestrator.features.startidcheck.publicapi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.gov.onelogin.criorchestrator.features.startidcheck.internalapi.StartIdCheckEntryPointsComponent
import uk.gov.onelogin.criorchestrator.sdk.sharedapi.CriOrchestratorComponent

@Composable
fun StartIdCheckCard(
    component: CriOrchestratorComponent,
    modifier: Modifier,
) {
    (component as StartIdCheckEntryPointsComponent).startIdCheckEntryPoints().StartIdCheckCard(
        modifier = modifier,
    )
}
