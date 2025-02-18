package uk.gov.onelogin.criorchestrator.features.session.internal

import com.squareup.anvil.annotations.ContributesBinding
import uk.gov.android.network.api.ApiRequest
import uk.gov.android.network.api.ApiResponse
import uk.gov.android.network.client.GenericHttpClient
import uk.gov.onelogin.criorchestrator.libraries.di.ActivityScope
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope
import javax.inject.Inject

@ActivityScope
@ContributesBinding(CriOrchestratorScope::class)
class SessionApiImpl
    @Inject
    constructor(
        private val httpClient: GenericHttpClient,
    ) : SessionApi {
        override suspend fun getActiveSession(): ApiResponse {
            //  DCMAW-10105: strings to be handled by a string resource configuration provider.
            //  This configuration will then be the backing for the developer settings, and
            //  the config will hold a map of keys and values (including feature flags) and then our
            //  developer settings can display it all, and some/all values can be updated via UI too
            val backendUrl = ""
            val endPoint = SessionApi.Endpoints.ActiveSession.endpoint
            val request =
                ApiRequest.Get(
                    url = backendUrl + endPoint,
                )
            val result =
                httpClient.makeAuthorisedRequest(
                    apiRequest = request,
                    scope = SCOPE,
                )
            return result
        }

        companion object {
            const val SCOPE = "IDCheckBackend"
        }
    }
