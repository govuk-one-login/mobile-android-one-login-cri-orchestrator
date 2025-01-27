package uk.gov.onelogin.criorchestrator.testwrapper.logging.testdouble

import uk.gov.logging.api.analytics.logging.AnalyticsLogger

interface AnalyticsLoggerModule {
    val analyticsLogger: AnalyticsLogger
}

