package uk.gov.onelogin.criorchestrator.testwrapper

import android.app.Application
import uk.gov.onelogin.criorchestrator.testwrapper.logging.testdouble.AnalyticsLoggerModule
import uk.gov.onelogin.criorchestrator.testwrapper.logging.testdouble.AnalyticsLoggerModuleImpl
import uk.gov.onelogin.criorchestrator.testwrapper.permission.PermissionConditionsModule
import uk.gov.onelogin.criorchestrator.testwrapper.permission.PermissionConditionsModuleImpl

class WrapperAppApplication : Application() {
    companion object {
        lateinit var analyticsLoggerModule: AnalyticsLoggerModule
        lateinit var permissionConditionsModule: PermissionConditionsModule
    }

    override fun onCreate() {
        super.onCreate()
        analyticsLoggerModule = AnalyticsLoggerModuleImpl(this)
        permissionConditionsModule = PermissionConditionsModuleImpl(this)
    }
}
