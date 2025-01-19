package uk.gov.onelogin.criorchestrator.features.startidcheck.internal

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.gov.android.ui.theme.GdsTheme

@Composable
fun StartIdCheckUiCard(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "HELLO WORLD CRI ORCHESTRATOR",
        modifier = modifier,
    )
}

const val CRI_ORCHESTRATOR = "CRI_ORCHESTRATOR"

@Preview
@Composable
fun StartIdCheckUiCardPreview() {
    GdsTheme {
        StartIdCheckUiCard()
    }
}
