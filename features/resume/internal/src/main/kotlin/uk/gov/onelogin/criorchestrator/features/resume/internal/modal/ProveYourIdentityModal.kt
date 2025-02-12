package uk.gov.onelogin.criorchestrator.features.resume.internal.modal

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import uk.gov.android.ui.pages.dialog.FullScreenDialog
import uk.gov.android.ui.theme.m3.GdsTheme

/**
 * A modal dialog that allows a user to prove their identity.
 *
 * If it is allowed to, this dialog will display automatically.
 *
 * @param state The modal UI state.
 * @param modifier See [Modifier].
 */
@Composable
internal fun ProveYourIdentityModal(
    state: ProveYourIdentityModalState,
    modifier: Modifier = Modifier,
) {
    if (!state.allowedToShow) {
        return
    }

    FullScreenDialog(
        modifier = modifier,
        onDismissRequest = state::onDismissRequest,
    ) {
        Text(
            text = "Not yet implemented",
            modifier = Modifier.padding(16.dp),
        )
    }
}

internal data class ProveYourIdentityModalPreviewParameters(
    val state: ProveYourIdentityModalState,
)

@Suppress("MaxLineLength") // Conflict between Ktlint formatting and Detekt rule
internal class ProveYourIdentityModalPreviewParameterProvider : PreviewParameterProvider<ProveYourIdentityModalPreviewParameters> {
    override val values =
        sequenceOf(
            ProveYourIdentityModalPreviewParameters(
                state = ProveYourIdentityModalState(allowedToShow = true),
            ),
            ProveYourIdentityModalPreviewParameters(
                state = ProveYourIdentityModalState(allowedToShow = false),
            ),
        )
}

@PreviewLightDark
@Composable
internal fun ProveYourIdentityModalPreview(
    @PreviewParameter(ProveYourIdentityModalPreviewParameterProvider::class)
    parameters: ProveYourIdentityModalPreviewParameters,
) = GdsTheme {
    ProveYourIdentityModal(
        state = parameters.state,
    )
}
