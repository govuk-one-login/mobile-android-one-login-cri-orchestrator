package uk.gov.onelogin.criorchestrator.testwrapper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import uk.gov.android.ui.theme.m3.GdsTheme
import uk.gov.onelogin.criorchestrator.testwrapper.logging.AnalyticsLoggerFactory
import uk.gov.onelogin.criorchestrator.testwrapper.logging.LoggerFactory
import uk.gov.onelogin.criorchestrator.testwrapper.logging.homeScreenViewEvent
import uk.gov.onelogin.criorchestrator.testwrapper.network.createHttpClient

class MainActivity : ComponentActivity() {
    private val logger = LoggerFactory.createLogger()

    private val analyticsLogger by lazy {
        AnalyticsLoggerFactory.createAnalyticsLogger(this, logger)
    }
    private val httpClient = createHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val config = TestWrapperConfig.provideConfig(resources)
        setContent {
            GdsTheme {
                MainContent(
                    httpClient = httpClient,
                    analyticsLogger = analyticsLogger,
                    config = config,
                    logger = logger,
                )
            }
        }
        analyticsLogger.logEvent(true, homeScreenViewEvent(this))
    }
}
