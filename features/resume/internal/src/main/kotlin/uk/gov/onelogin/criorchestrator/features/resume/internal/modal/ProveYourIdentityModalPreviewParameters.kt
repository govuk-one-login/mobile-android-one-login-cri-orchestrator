package uk.gov.onelogin.criorchestrator.features.resume.internal.modal

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

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
