package uk.gov.onelogin.criorchestrator.testwrapper.logging.testdouble

import android.content.Context
import uk.gov.logging.api.analytics.logging.AnalyticsLogger
import uk.gov.logging.testdouble.analytics.ToastingAnalyticsLogger

class AnalyticsLoggerModuleImpl(
    private val context: Context,
): AnalyticsLoggerModule {
    override val analyticsLogger: AnalyticsLogger by lazy {
    ToastingAnalyticsLogger(context)
    }
}