package uk.gov.onelogin.criorchestrator.sdk.internal

import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import uk.gov.android.network.client.GenericHttpClient
import uk.gov.onelogin.criorchestrator.libraries.di.ActivityScope
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope

@ActivityScope
@MergeComponent(CriOrchestratorScope::class)
interface BaseCriOrchestratorComponent {

    @MergeComponent.Factory
    interface Factory {
        fun create(
            @BindsInstance authenticatedHttpClient: GenericHttpClient,
        ): BaseCriOrchestratorComponent
    }
}
