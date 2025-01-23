package uk.gov.onelogin.criorchestrator.testwrapper.logging.testdouble

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.gov.logging.api.analytics.logging.AnalyticsLogger
import uk.gov.logging.impl.analytics.FirebaseAnalyticsLogger
import javax.inject.Singleton

class GovUkLoggingHiltConfig {
    @InstallIn(SingletonComponent::class)
    @Module
    object AnalyticsSingletonModule {
        @Provides
        @Singleton
        fun providesAnalyticsLogger(analyticsLogger: FirebaseAnalyticsLogger): AnalyticsLogger =
            analyticsLogger
    }
}
