package uk.gov.onelogin.criorchestrator.features.startidcheck.internalapi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.squareup.anvil.annotations.ContributesTo
import uk.gov.onelogin.criorchestrator.libraries.di.ActivityScope
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope

interface StartIdCheckEntryPoints {
    @Composable
    fun StartIdCheckCard(modifier: Modifier)
}

@ActivityScope
@ContributesTo(CriOrchestratorScope::class)
interface StartIdCheckEntryPointsComponent {
    fun startIdCheckEntryPoints(): StartIdCheckEntryPoints
}
