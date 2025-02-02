package uk.gov.onelogin.criorchestrator.testwrapper.logging

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import org.jetbrains.annotations.VisibleForTesting
import uk.gov.logging.api.analytics.logging.AnalyticsLogger
import uk.gov.logging.impl.AndroidLogger
import uk.gov.logging.impl.CrashlyticsLogger
import uk.gov.logging.impl.analytics.FirebaseAnalyticsLogger

object AnalyticsLoggerFactory {
    @VisibleForTesting
    internal var testLogger: AnalyticsLogger? = null

    fun createAnalyticsLogger(context: Context): AnalyticsLogger =
        testLogger ?: FirebaseAnalyticsLogger(
            analytics = FirebaseAnalytics.getInstance(context),
            logger = AndroidLogger(CrashlyticsLogger(FirebaseCrashlytics.getInstance())),
        )
}
