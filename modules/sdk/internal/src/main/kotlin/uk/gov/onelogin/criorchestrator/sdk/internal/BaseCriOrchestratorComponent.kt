package uk.gov.onelogin.criorchestrator.sdk.internal

import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import uk.gov.android.network.client.GenericHttpClient
import uk.gov.onelogin.criorchestrator.libraries.di.ActivityScope
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope

/**
 * The real Dagger component that other component interfaces and modules will be merged into.
 */
@ActivityScope
@MergeComponent(CriOrchestratorScope::class, dependencies = [])
interface BaseCriOrchestratorComponent {

    @MergeComponent.Factory
    interface Factory {
        fun create(
            @BindsInstance authenticatedHttpClient: GenericHttpClient,
        ): BaseCriOrchestratorComponent
    }
}
