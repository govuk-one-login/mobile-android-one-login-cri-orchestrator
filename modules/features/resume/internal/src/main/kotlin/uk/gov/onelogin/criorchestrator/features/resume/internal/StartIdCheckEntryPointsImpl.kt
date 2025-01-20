package uk.gov.onelogin.criorchestrator.features.startidcheck.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.squareup.anvil.annotations.ContributesBinding
import uk.gov.onelogin.criorchestrator.features.startidcheck.internalapi.StartIdCheckEntryPoints
import uk.gov.onelogin.criorchestrator.libraries.di.ActivityScope
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope
import javax.inject.Inject

@ActivityScope
@ContributesBinding(CriOrchestratorScope::class)
class StartIdCheckEntryPointsImpl @Inject constructor() : StartIdCheckEntryPoints {
    @Composable
    override fun StartIdCheckCard(
        modifier: Modifier,
    ) {
        StartIdCheckUiCard(
            modifier = Modifier,
        )
    }
}
