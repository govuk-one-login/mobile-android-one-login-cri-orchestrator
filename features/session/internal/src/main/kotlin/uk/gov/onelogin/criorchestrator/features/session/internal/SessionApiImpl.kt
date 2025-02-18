package uk.gov.onelogin.criorchestrator.features.session.internal

import android.util.Log
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.serialization.json.Json
import uk.gov.android.network.api.ApiRequest
import uk.gov.android.network.api.ApiResponse
import uk.gov.android.network.client.GenericHttpClient
import uk.gov.onelogin.criorchestrator.features.session.internal.response.ActiveSessionApiResponse
import uk.gov.onelogin.criorchestrator.features.session.internal.response.ActiveSessionApiResponse.ActiveSessionError
import uk.gov.onelogin.criorchestrator.features.session.internal.response.ActiveSessionErrorResponse
import uk.gov.onelogin.criorchestrator.features.session.internal.response.mapErrorStatusCodeToError
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

            val handledResponse = when (result) {
                is ApiResponse.Success<*> -> handleSuccessResponse(result)
                is ApiResponse.Failure -> handleFailureResponse(result)
                // Not sure how to handle others
                else -> handleFailureResponse(result)
            }

            return handledResponse
        }

        private fun handleSuccessResponse(
            successResponse: ApiResponse.Success<*>
        ): ActiveSessionApiResponse {
            try {
                val successResponseString: String = successResponse.response.toString()
                val activeSessionApiSuccessResponse: ActiveSessionApiResponse.ActiveSessionSuccess =
                    Json.decodeFromString(successResponseString)
                return activeSessionApiSuccessResponse
            } catch (e: Exception) {
                Log.e(this::class.java.simpleName, e.message, e)
                val unknownErrorResponse = ActiveSessionError(
                    error = ActiveSessionErrorResponse.UNKNOWN,
                    errorDescription = JSON_DECODE_ERROR,
                )
                return unknownErrorResponse
            }
        }

        private fun handleFailureResponse(
            failureResponse: ApiResponse.Failure
        ): ActiveSessionApiResponse =
            ActiveSessionError(
                error = mapErrorStatusCodeToError(failureResponse.status),
                errorDescription = failureResponse.error.message ?: JSON_DECODE_ERROR,
            )

        companion object {
            const val SCOPE = "IDCheckBackend"
            const val JSON_DECODE_ERROR = "ERROR: Decode AttestationResponse.Success error"
        }
    }
