package uk.gov.onelogin.criorchestrator.sdk.resume

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.gov.android.ui.componentsv2.GdsCard
import uk.gov.android.ui.theme.m3.GdsTheme
import uk.gov.onelogin.criorchestrator.sdk.CriOrchestrator
import uk.gov.onelogin.criorchestrator.sdk.R

@Composable
fun ProveYourIdentityCard(
    @Suppress("UnusedParameter") component: CriOrchestrator,
    modifier: Modifier = Modifier,
) {
    GdsCard(
        title = stringResource(R.string.start_id_check_title),
        body = stringResource(R.string.start_id_check_content),
        buttonText = stringResource(R.string.start_id_check_primary_button),
        modifier = modifier,
        onClick = {
            // Identity Proofing and Verification (IPV)
            // display the ID Check Dialog:
            // DCMAW-10056: Android | Resume IPV | Create 'Start ID Check' modal UI
        },
    )
}

@Composable
@PreviewLightDark
internal fun ProveYourIdentityCardPreview() {
    GdsTheme {
        ProveYourIdentityCard(
            component = CriOrchestrator(),
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
