package uk.gov.onelogin.criorchestrator.testwrapper

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.gov.android.network.client.GenericHttpClient
import uk.gov.android.ui.theme.m3.GdsTheme
import uk.gov.onelogin.criorchestrator.features.resume.publicapi.ProveYourIdentityCard
import uk.gov.onelogin.criorchestrator.sdk.publicapi.rememberCriOrchestrator
import uk.gov.onelogin.criorchestrator.testwrapper.network.createHttpClient

@Composable
fun MainContent(
    httpClient: GenericHttpClient,
    modifier: Modifier = Modifier,
) {
    val criOrchestratorComponent =
        rememberCriOrchestrator(
            authenticatedHttpClient = httpClient,
        )
    ProveYourIdentityCard(
        component = criOrchestratorComponent,
        modifier = modifier,
    )
}

@Composable
@PreviewLightDark
internal fun MainContentPreview() =
    GdsTheme {
        MainContent(
            httpClient = createHttpClient(),
        )
    }
