package uk.gov.onelogin.criorchestrator.features.resume.internal

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.gov.android.ui.theme.m3.GdsTheme
import uk.gov.logging.testdouble.analytics.FakeAnalyticsLogger
import uk.gov.onelogin.criorchestrator.libraries.androidutils.AndroidResourceProvider

@Composable
internal fun ProveYourIdentityRoot(
    viewModel: ProveYourIdentityViewModel,
    modifier: Modifier = Modifier,
) {
    ProveYourIdentityUiCard(
        onStartClick = viewModel::start,
        modifier = modifier,
    )
}

@Composable
@PreviewLightDark
internal fun ProveYourIdentityRootPreview() {
    val context = LocalContext.current
    val fakeResourceProvider by lazy {
        AndroidResourceProvider(
            context,
        )
    }
    val fakeViewModel =
        ProveYourIdentityViewModel(
            analyticsLogger = FakeAnalyticsLogger(),
            resourceProvider = fakeResourceProvider,
        )

    GdsTheme {
        ProveYourIdentityRoot(
            fakeViewModel,
        )
    }
}
