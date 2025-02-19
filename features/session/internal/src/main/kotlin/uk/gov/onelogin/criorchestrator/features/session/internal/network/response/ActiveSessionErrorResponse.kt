package uk.gov.onelogin.criorchestrator.features.session.internal.network.response

import io.ktor.http.HttpStatusCode

enum class ActiveSessionErrorResponse {
    SERVER_ERROR,
    SESSION_NOT_FOUND,
    INVALID_REQUEST,
    UNAUTHORIZED,
    UNKNOWN,
}

fun mapErrorStatusCodeToError(statusCode: Int): ActiveSessionErrorResponse =
    when (statusCode) {
        HttpStatusCode.BadRequest.value -> ActiveSessionErrorResponse.INVALID_REQUEST
        HttpStatusCode.Unauthorized.value -> ActiveSessionErrorResponse.UNAUTHORIZED
        HttpStatusCode.NotFound.value -> ActiveSessionErrorResponse.SESSION_NOT_FOUND
        HttpStatusCode.InternalServerError.value -> ActiveSessionErrorResponse.SERVER_ERROR
        else -> ActiveSessionErrorResponse.UNKNOWN
    }
