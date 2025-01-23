package uk.gov.onelogin.criorchestrator.testwrapper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import uk.gov.android.network.api.ApiResponse
import uk.gov.android.network.client.StubHttpClient
import uk.gov.android.ui.theme.m3.GdsTheme
import uk.gov.onelogin.criorchestrator.features.resume.publicapi.ProveYourIdentityCard
import uk.gov.logging.api.analytics.AnalyticsEvent
import uk.gov.logging.api.analytics.logging.AnalyticsLogger
import uk.gov.logging.api.analytics.parameters.ScreenViewParameters
import uk.gov.onelogin.criorchestrator.sdk.publicapi.rememberCriOrchestrator
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    var analyticsLogger: AnalyticsLogger? = null

    private val screenViewEvent =
        ScreenViewParameters(
            clazz = this::class.java.simpleName,
            name = "TestWrapper",
            title = "Test Wrapper app",
        ).let {
            AnalyticsEvent.screenView(it)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val criOrchestratorComponent =
                rememberCriOrchestrator(
                    StubHttpClient(
                        apiResponse = ApiResponse.Offline,
                    ),
                )
            GdsTheme {
                ProveYourIdentityCard(
                    component = criOrchestratorComponent,
                    modifier = Modifier,
                )
            }
        }
        analyticsLogger?.logEvent(
            true,
            screenViewEvent
        )
    }
}
