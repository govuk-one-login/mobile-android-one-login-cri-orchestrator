package uk.gov.onelogin.criorchestrator.features.resume.internal

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.gov.android.ui.componentsv2.GdsCard
import uk.gov.android.ui.theme.m3.GdsTheme

@Composable
internal fun ProveYourIdentityUiCard(modifier: Modifier = Modifier) {
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
internal fun ProveYourIdentityUiCardPreview() {
    GdsTheme {
        ProveYourIdentityUiCard(
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
