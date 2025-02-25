package uk.gov.onelogin.criorchestrator.features.session.internal.network

import com.squareup.anvil.annotations.ContributesBinding
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import uk.gov.android.network.api.ApiRequest
import uk.gov.android.network.api.ApiResponse
import uk.gov.android.network.client.GenericHttpClient
import uk.gov.logging.api.LogTagProvider
import uk.gov.logging.api.Logger
import uk.gov.onelogin.criorchestrator.features.config.publicapi.ConfigStore
import uk.gov.onelogin.criorchestrator.libraries.di.ActivityScope
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope
import javax.inject.Inject

private const val GET_ACTIVE_SESSION_ENDPOINT = "/async/activeSession"

@ActivityScope
@ContributesBinding(CriOrchestratorScope::class, boundType = SessionApi::class)
class SessionApiImpl
    @Inject
    constructor(
        private val httpClient: GenericHttpClient,
        private val configStore: ConfigStore,
        private val logger: Logger,
    ) : SessionApi,
        LogTagProvider {
        private val _responseStateFlow =
            MutableStateFlow<ApiResponse>(
                ApiResponse.Failure(
                    HttpStatusCode.BadRequest.value,
                    Exception(""),
                ),
            )

        override val responseStateFlow: StateFlow<ApiResponse>
            get() = _responseStateFlow.asStateFlow()

        override suspend fun getActiveSessionFromCollectedConfig() {
            configStore.keyValueMapStateFlow.collect { map ->
                getActiveSession(map)
            }
        }

        suspend fun getActiveSession(map: Map<String, Any>) {
            logger.debug(
                tag,
                "Collected config map $map",
            )
            val request =
                ApiRequest.Get(
                    url =
                        map.getValue("backendAsyncUrl") as String +
                            GET_ACTIVE_SESSION_ENDPOINT,
                )
            val response =
                httpClient.makeAuthorisedRequest(
                    apiRequest = request,
                    scope = SCOPE,
                )
            _responseStateFlow.value = response
        }

        companion object {
            const val SCOPE = "idCheck.activeSession.read"
        }
    }
