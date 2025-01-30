package uk.gov.onelogin.criorchestrator.testwrapper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.gov.android.network.client.GenericHttpClient
import uk.gov.android.ui.theme.m3.GdsTheme
import uk.gov.onelogin.criorchestrator.features.resume.publicapi.ProveYourIdentityCard
import uk.gov.onelogin.criorchestrator.sdk.publicapi.rememberCriOrchestrator
import uk.gov.onelogin.criorchestrator.testwrapper.logging.AnalyticsLoggerFactory
import uk.gov.onelogin.criorchestrator.testwrapper.logging.homeScreenViewEvent
import uk.gov.onelogin.criorchestrator.testwrapper.network.createHttpClient

class MainActivity : ComponentActivity() {
    private val analyticsLogger by lazy {
        AnalyticsLoggerFactory.createAnalyticsLogger(this)
    }
    private val httpClient = createHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GdsTheme {
                MainContent(
                    httpClient = httpClient,
                )
            }
        }
        analyticsLogger.logEvent(true, homeScreenViewEvent(this))
    }
}

@Composable
fun MainContent(httpClient: GenericHttpClient) {
    val criOrchestratorComponent =
        rememberCriOrchestrator(
            authenticatedHttpClient = httpClient,
        )
    ProveYourIdentityCard(
        component = criOrchestratorComponent,
        modifier = Modifier,
    )
}

@Composable
@PreviewLightDark
fun MainContentPreview() {
    MainContent(
        httpClient = createHttpClient(),
    )
}
