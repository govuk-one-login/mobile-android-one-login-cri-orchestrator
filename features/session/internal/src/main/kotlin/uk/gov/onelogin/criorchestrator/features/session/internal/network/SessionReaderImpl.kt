package uk.gov.onelogin.criorchestrator.features.session.internal.network

import android.util.Log
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.serialization.json.Json
import uk.gov.android.network.api.ApiResponse
import uk.gov.logging.api.LogTagProvider
import uk.gov.onelogin.criorchestrator.features.session.internal.network.response.ActiveSessionApiResponse
import uk.gov.onelogin.criorchestrator.features.session.internalapi.domain.SessionReader
import uk.gov.onelogin.criorchestrator.libraries.di.ActivityScope
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope
import javax.inject.Inject

@ActivityScope
@ContributesBinding(CriOrchestratorScope::class, boundType = SessionReader::class)
class SessionReaderImpl
@Inject
constructor(
    private val sessionApi: SessionApi,
) : SessionReader, LogTagProvider {
    override suspend fun isActiveSession(): Boolean {
        val activeSessionResponse = sessionApi.getActiveSession()
        return when (activeSessionResponse) {
            is ApiResponse.Success<*> -> handleSuccessResponse(activeSessionResponse)
            is ApiResponse.Failure -> handleFailureResponse(activeSessionResponse)
            ApiResponse.Loading -> handleLoadingResponse()
            ApiResponse.Offline -> handleOfflineResponse()
        }
    }

    private fun handleSuccessResponse(
        response: ApiResponse.Success<*>
    ): Boolean = try {
        val parsedResponse: ActiveSessionApiResponse.ActiveSessionSuccess =
            Json.decodeFromString(response.response.toString())
        // TODO: Replace with Logger
        // TODO: Is the session ID private or can it be logged?
        Log.d(tag, "Got active session: id=${parsedResponse.sessionId}")
        true
    } catch (e: IllegalArgumentException) {
        // TODO: Replace with Logger
        Log.e(tag, "Failed to parse active session response", e)
        false
    }

    private fun handleFailureResponse(
        response: ApiResponse.Failure,
    ): Boolean {
        Log.e(tag, "Failed to fetch active session", response.error)
        return false
    }

    private fun handleOfflineResponse(): Boolean {
        Log.d(tag, "Failed to fetch active session - device is offline")
        return false
    }

    private fun handleLoadingResponse(): Boolean = false
}
