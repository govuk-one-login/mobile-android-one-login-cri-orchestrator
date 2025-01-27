package uk.gov.onelogin.criorchestrator.testwrapper.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uk.gov.idcheck.features.api.permissions.AnalyticsPermissions
import uk.gov.idcheck.features.api.permissions.PermissionConditions
import uk.gov.logging.api.analytics.AnalyticsEvent
import uk.gov.logging.api.analytics.logging.AnalyticsLogger
import uk.gov.onelogin.criorchestrator.testwrapper.logging.testdouble.AnalyticsLoggerExtensions.logEvent

class AnalyticsLoggerViewModel(
    private val analyticsLogger: AnalyticsLogger,
): ViewModel() {

    fun logEvent(
        analyticsPermissions: AnalyticsPermissions,
        permissionConditions: PermissionConditions,
        screenViewEvent: AnalyticsEvent,
    ) {
        viewModelScope.launch {
            analyticsLogger.logEvent(
                analyticsPermissions,
                permissionConditions,
                screenViewEvent,
            )
        }
    }

}