package uk.gov.onelogin.criorchestrator.features.session.internal.response

enum class ActiveSessionErrorResponse {
    SERVER_ERROR,
    INVALID_SESSION,
    SESSION_NOT_FOUND,
    INVALID_REQUEST,
    UNAUTHORIZED,
    UNKNOWN;

    fun mapResponseToError(response: String) {
        when(response) {
            "server_error" -> SERVER_ERROR
            "invalid_session" -> INVALID_SESSION
            "session_not_found" -> SESSION_NOT_FOUND
            "invalid_request" -> INVALID_REQUEST
            "unauthorized" -> UNAUTHORIZED
            else -> UNKNOWN
        }
    }
}