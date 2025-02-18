package uk.gov.onelogin.criorchestrator.features.resume.internal.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.gov.android.ui.theme.m3.GdsTheme

@Composable
internal fun ContinueToProveYourIdentityScreen() {
    Text(
        text = "Not yet implemented",
        modifier = Modifier.padding(16.dp),
    )
}

@PreviewLightDark
@Composable
internal fun ContinueToProveYourIdentityScreenPreview() =
    GdsTheme {
        ContinueToProveYourIdentityScreen()
    }
