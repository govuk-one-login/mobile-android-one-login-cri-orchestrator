package uk.gov.onelogin.criorchestrator.testwrapper.permission

import android.content.Context
import uk.gov.idcheck.features.api.permissions.ActivityPermissionConditions
import uk.gov.idcheck.features.api.permissions.PermissionConditions

class PermissionConditionsModuleImpl(
    private val context: Context
): PermissionConditionsModule {
    override val permissionConditions: PermissionConditions by lazy {
        ActivityPermissionConditions(context)
    }
}