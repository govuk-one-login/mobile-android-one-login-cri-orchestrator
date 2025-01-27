package uk.gov.onelogin.criorchestrator.testwrapper.logging.testdouble

import uk.gov.idcheck.features.api.permissions.AnalyticsPermissions
import uk.gov.idcheck.features.api.permissions.PermissionConditions
import uk.gov.logging.api.analytics.AnalyticsEvent
import uk.gov.logging.api.analytics.logging.AnalyticsLogger

object AnalyticsLoggerExtensions {
    fun AnalyticsLogger.logEvent(
        analyticsPermissions: AnalyticsPermissions,
        conditions: PermissionConditions,
        vararg events: AnalyticsEvent,
    ) = this.logEvent(
        shouldLogEvent =
        conditions.hasGrantedPermission(
            analyticsPermissions,
        ),
        *events,
    )
}