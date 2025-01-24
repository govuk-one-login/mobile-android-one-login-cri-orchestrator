package uk.gov.onelogin.criorchestrator.features.resume.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.squareup.anvil.annotations.ContributesBinding
import uk.gov.onelogin.criorchestrator.features.resume.internalapi.ProveYourIdentityEntryPoints
import uk.gov.onelogin.criorchestrator.libraries.di.ActivityScope
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope
import javax.inject.Inject

@ActivityScope
@ContributesBinding(CriOrchestratorScope::class)
class ProveYourIdentityEntryPointsImpl @Inject constructor() : ProveYourIdentityEntryPoints {
    @Composable
    override fun ProveYourIdentityCard(modifier: Modifier) {
        ProveYourIdentityUiCard(
            modifier = Modifier,
        )
    }
}
