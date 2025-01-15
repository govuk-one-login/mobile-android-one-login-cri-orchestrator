package uk.gov.onelogin.criorchestrator.sdk.internal

import uk.gov.onelogin.libinit.libraries.di.SdkSingletonScope

@javax.inject.Singleton
@com.squareup.anvil.annotations.MergeComponent(uk.gov.onelogin.libinit.libraries.di.SdkSingletonScope::class)
interface BaseSdkSingletonComponent {

    @com.squareup.anvil.annotations.MergeComponent.Factory
    interface Factory {
        fun create(): BaseSdkSingletonComponent
    }

    fun inject(sdkSingletonImpl: uk.gov.onelogin.libinit.sdk.internal.SdkSingletonImpl)
}
