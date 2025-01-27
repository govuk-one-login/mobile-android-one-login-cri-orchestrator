package uk.gov.onelogin.criorchestrator.testwrapper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import uk.gov.android.network.api.ApiResponse
import uk.gov.android.network.client.StubHttpClient
import uk.gov.android.ui.theme.m3.GdsTheme
import uk.gov.idcheck.features.api.permissions.ActivityPermissionConditions
import uk.gov.idcheck.features.api.permissions.AnalyticsPermissions
import uk.gov.logging.api.analytics.AnalyticsEvent
import uk.gov.logging.api.analytics.parameters.ScreenViewParameters
import uk.gov.onelogin.criorchestrator.features.resume.publicapi.ProveYourIdentityCard
import uk.gov.onelogin.criorchestrator.sdk.publicapi.rememberCriOrchestrator
import uk.gov.onelogin.criorchestrator.testwrapper.presentation.AnalyticsLoggerViewModel
import uk.gov.onelogin.criorchestrator.testwrapper.presentation.viewModelFactory
import uk.gov.onelogin.idcheck.features.api.R


class MainActivity: ComponentActivity() {
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
            val analyticsViewModel = viewModel<AnalyticsLoggerViewModel>(
                factory = viewModelFactory {
                    AnalyticsLoggerViewModel(
                        WrapperAppApplication.analyticsLoggerModule.analyticsLogger
                    )
                }
            )

            val criOrchestratorComponent = rememberCriOrchestrator(
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
            analyticsViewModel.logEvent(
                AnalyticsPermissions.getGoogleAnalytics(
                    "${this.getString(
                        R.string.namespace,
                    )}${this.getString(R.string.googlePermissionSuffix)}",
                ),
                ActivityPermissionConditions(this),
                screenViewEvent,
            )
        }
    }
}
