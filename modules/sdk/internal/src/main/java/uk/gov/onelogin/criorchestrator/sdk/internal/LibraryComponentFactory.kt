package uk.gov.onelogin.criorchestrator.sdk.internal

import androidx.activity.ComponentActivity

fun createCriOrchestratorComponent(
    criOrchestratorSingleton: uk.gov.onelogin.libinit.sdk.sharedapi.SdkSingleton,
    authenticatedHttpClient: uk.gov.onelogin.libinit.libraries.network.AuthenticatedHttpClient,
    activity: ComponentActivity,
): uk.gov.onelogin.libinit.sdk.sharedapi.SdkComponent {
    val component = uk.gov.onelogin.libinit.sdk.sharedapi.SdkSingleton.component
    return uk.gov.onelogin.libinit.sdk.internal.MergedBaseSdkComponent.Factory.create(
        clearDataComponent = component as uk.gov.onelogin.libinit.features.cleardata.api.ClearDataComponent,
        activeSessionComponent = component as uk.gov.onelogin.libinit.features.activesession.internalapi.ActiveSessionComponent,
        activity = activity,
        authenticatedHttpClient = authenticatedHttpClient,
    )
}
