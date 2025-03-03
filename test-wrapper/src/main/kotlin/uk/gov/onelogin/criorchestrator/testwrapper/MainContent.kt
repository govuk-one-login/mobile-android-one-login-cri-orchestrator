package uk.gov.onelogin.criorchestrator.testwrapper

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.gov.android.network.client.GenericHttpClient
import uk.gov.android.ui.theme.m3.GdsTheme
import uk.gov.logging.api.Logger
import uk.gov.logging.api.analytics.logging.AnalyticsLogger
import uk.gov.logging.testdouble.SystemLogger
import uk.gov.logging.testdouble.analytics.FakeAnalyticsLogger
import uk.gov.onelogin.criorchestrator.features.config.publicapi.Config
import uk.gov.onelogin.criorchestrator.features.resume.publicapi.ProveYourIdentityCard
import uk.gov.onelogin.criorchestrator.sdk.publicapi.rememberCriOrchestrator
import uk.gov.onelogin.criorchestrator.testwrapper.devmenu.DevMenuRoot
import uk.gov.onelogin.criorchestrator.testwrapper.network.createHttpClient

@Composable
fun MainContent(
    httpClient: GenericHttpClient,
    analyticsLogger: AnalyticsLogger,
    config: Config,
    logger: Logger,
    modifier: Modifier = Modifier,
) {
    val criOrchestratorComponent =
        rememberCriOrchestrator(
            authenticatedHttpClient = httpClient,
            analyticsLogger = analyticsLogger,
            initialConfig = config,
            logger = logger,
        )
    Column(
        modifier =
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        ProveYourIdentityCard(
            component = criOrchestratorComponent,
            modifier = modifier,
        )
        Row(
            modifier =
                Modifier
                    .align(Alignment.End),
            verticalAlignment = Alignment.Bottom,
        ) {
            DevMenuRoot(
                initialConfig = config,
            )
        }
    }
}

@Composable
@PreviewLightDark
internal fun MainContentPreview() {
    val config = TestWrapperConfig.provideConfig(LocalContext.current.resources)
    GdsTheme {
        MainContent(
            httpClient = createHttpClient(),
            analyticsLogger = FakeAnalyticsLogger(),
            config = config,
            logger = SystemLogger(),
            modifier = Modifier,
        )
    }
}
