package uk.gov.onelogin.criorchestrator.features.session.internal

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import uk.gov.android.network.api.ApiResponse
import uk.gov.android.network.client.StubHttpClient

class SessionApiImplTest {
    // DCMAW-10105: stubbed responses in tests should reflect what we expect the API to return so
    // that we can test how the SessionApiImpl handles and maps different types of responses
    private val sessionApiImpl =
        SessionApiImpl(
            StubHttpClient(
                ApiResponse.Success<String>("Test"),
            ),
        )

    @Test
    fun `session API implementation returns stubbed API response`() {
        val expected = ApiResponse.Success("Test")
        val result =
            runBlocking {
                return@runBlocking sessionApiImpl.getActiveSession()
            }
        assertEquals(result, expected)
    }
}
