package uk.gov.onelogin.criorchestrator.features.session.internal.network

import kotlinx.coroutines.flow.StateFlow
import uk.gov.android.network.api.ApiResponse

interface SessionApi {
    val responseStateFlow: StateFlow<ApiResponse>

    suspend fun getActiveSessionFromCollectedConfig()
}
