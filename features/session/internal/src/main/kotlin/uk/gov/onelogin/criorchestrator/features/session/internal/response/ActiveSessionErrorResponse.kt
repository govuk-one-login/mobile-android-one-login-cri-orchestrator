package uk.gov.onelogin.criorchestrator.features.session.internal.response

enum class ActiveSessionErrorResponse {
    SERVER_ERROR,
    SESSION_NOT_FOUND,
    INVALID_REQUEST,
    UNAUTHORIZED,
    UNKNOWN,
}

fun mapErrorStatusCodeToError(statusCode: Int): ActiveSessionErrorResponse =
    when (statusCode) {
        400 -> ActiveSessionErrorResponse.INVALID_REQUEST
        401 -> ActiveSessionErrorResponse.UNAUTHORIZED
        404 -> ActiveSessionErrorResponse.SESSION_NOT_FOUND
        500 -> ActiveSessionErrorResponse.SERVER_ERROR
        else -> ActiveSessionErrorResponse.UNKNOWN
    }
