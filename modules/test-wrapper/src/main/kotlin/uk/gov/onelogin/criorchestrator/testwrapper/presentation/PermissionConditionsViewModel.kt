package uk.gov.onelogin.criorchestrator.testwrapper.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uk.gov.idcheck.features.api.permissions.Permission
import uk.gov.idcheck.features.api.permissions.PermissionConditions

class PermissionConditionsViewModel(
    private val permissionConditions: PermissionConditions
): ViewModel() {
    fun hasGrantedPermission(permission: Permission) {
         viewModelScope.launch {
             permissionConditions.hasGrantedPermission(
                 permission
            )
        }
    }

    fun shouldShowRequestRationale(permission: Permission) {
        viewModelScope.launch {
            permissionConditions.shouldShowRequestRationale(
                permission
            )
        }
    }
}