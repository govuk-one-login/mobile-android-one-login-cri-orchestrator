package uk.gov.onelogin.criorchestrator.features.session.internal.network

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
                ApiResponse.Success<String>(
                    """
                    {
                        "sessionId": "37aae92b-a51e-4f68-b571-8e455fb0ec34",
                        "redirectUri": "https://example/redirect",
                        "state": "11112222333344445555666677778888"
                    }
                    """.trimIndent(),
                ),
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
