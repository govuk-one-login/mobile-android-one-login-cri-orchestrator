package uk.gov.onelogin.criorchestrator.features.session.internal

import uk.gov.android.network.api.ApiResponse

fun interface SessionApi {
    // DCMAW-10105: return type exposes the raw network response - convert it into something like a
    // domain model within the SessionApiImpl
    suspend fun getActiveSession(): ApiResponse

    sealed class Endpoints(
        val endpoint: String,
    ) {
        data object ActiveSession : Endpoints("async/activeSession")
    }
}
