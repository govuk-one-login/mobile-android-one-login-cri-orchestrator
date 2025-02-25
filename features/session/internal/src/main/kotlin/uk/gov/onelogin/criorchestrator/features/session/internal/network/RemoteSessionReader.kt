package uk.gov.onelogin.criorchestrator.features.session.internal.network

import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.serialization.json.Json
import uk.gov.android.network.api.ApiResponse
import uk.gov.logging.api.LogTagProvider
import uk.gov.logging.api.Logger
import uk.gov.onelogin.criorchestrator.features.session.internal.network.response.ActiveSessionApiResponse
import uk.gov.onelogin.criorchestrator.features.session.internal.network.session.SessionStore
import uk.gov.onelogin.criorchestrator.features.session.internalapi.domain.Session
import uk.gov.onelogin.criorchestrator.features.session.internalapi.domain.SessionReader
import uk.gov.onelogin.criorchestrator.libraries.di.ActivityScope
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope
import javax.inject.Inject

@ActivityScope
@ContributesBinding(CriOrchestratorScope::class, boundType = SessionReader::class)
class RemoteSessionReader
    @Inject
    constructor(
        private val sessionStore: SessionStore,
        private val sessionApi: SessionApi,
        private val logger: Logger,
    ) : SessionReader,
        LogTagProvider {
        private val _isActiveSessionStateFlow = MutableStateFlow<Boolean>(false)

        override val isActiveSessionStateFlow: StateFlow<Boolean> =
            _isActiveSessionStateFlow.asStateFlow()

        override suspend fun handleCollectedResponse() {
            sessionApi.responseStateFlow.collect { response ->
                logger.debug(
                    tag,
                    "Collected response $response",
                )
                handleResponse(response)
            }
        }

        fun handleResponse(response: ApiResponse) {
            when (response) {
                is ApiResponse.Success<*> -> handleSuccessResponse(response)
                is ApiResponse.Failure -> handleFailureResponse(response)
                ApiResponse.Loading -> false
                ApiResponse.Offline -> handleOfflineResponse()
            }
        }

        override suspend fun setupDownstreamCollection() {
            sessionApi.getActiveSessionFromCollectedConfig()
        }

        private fun handleSuccessResponse(response: ApiResponse.Success<*>) =
            try {
                logger.debug(tag, "Got active session")
                val parsedResponse: ActiveSessionApiResponse.ActiveSessionSuccess =
                    Json.decodeFromString(response.response.toString())
                sessionStore.write(
                    Session(
                        sessionId = parsedResponse.sessionId,
                        redirectUri = parsedResponse.redirectUri,
                        state = parsedResponse.state,
                    ),
                )
                _isActiveSessionStateFlow.value = true
            } catch (e: IllegalArgumentException) {
                logger.error(tag, "Failed to parse active session response", e)
                _isActiveSessionStateFlow.value = false
            }

        private fun handleFailureResponse(response: ApiResponse.Failure) {
            logger.error(tag, "Failed to fetch active session", response.error)
            _isActiveSessionStateFlow.value = false
        }

        private fun handleOfflineResponse() {
            logger.debug(tag, "Failed to fetch active session - device is offline")
            _isActiveSessionStateFlow.value = false
        }
    }
