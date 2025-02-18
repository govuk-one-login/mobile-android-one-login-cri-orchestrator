package uk.gov.onelogin.criorchestrator.features.session.internal.response

import java.util.UUID

sealed class ActiveSessionApiResponse {
    data class ActiveSessionSuccess(
        val sessionId: UUID,
        val redirectUri: String,
        val state: String,
    )

    data class ActiveSessionError(
        val error: ActiveSessionErrorResponse,
        val errorDescription: String,
    )
}
