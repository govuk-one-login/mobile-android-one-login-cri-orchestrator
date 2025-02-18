package uk.gov.onelogin.criorchestrator.features.session.internal

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import uk.gov.android.network.api.ApiResponse
import uk.gov.onelogin.criorchestrator.features.session.internal.network.SessionReaderImpl

class SessionReaderImplTest {
    val sessionApi = StubSessionApiImpl()

    @Test
    fun `SessionReaderImpl returns false when active session API returns Failure`() {
        sessionApi.setActiveSession(
            ApiResponse.Failure(
                status = 0,
                error = Exception("test exception"),
            ),
        )

        val fakeSessionReaderImpl =
            SessionReaderImpl(
                sessionApi = sessionApi,
            )

        val result =
            runBlocking {
                return@runBlocking fakeSessionReaderImpl.isActiveSession()
            }

        assertFalse(result)
    }

    @Test
    fun `SessionReaderImpl returns false when active session API returns Loading`() {
        sessionApi.setActiveSession(
            ApiResponse.Loading,
        )

        val fakeSessionReaderImpl =
            SessionReaderImpl(
                sessionApi = sessionApi,
            )

        val result =
            runBlocking {
                return@runBlocking fakeSessionReaderImpl.isActiveSession()
            }

        assertFalse(result)
    }

    @Test
    fun `SessionReaderImpl returns false when active session API returns Offline`() {
        sessionApi.setActiveSession(
            ApiResponse.Offline,
        )

        val fakeSessionReaderImpl =
            SessionReaderImpl(
                sessionApi = sessionApi,
            )

        val result =
            runBlocking {
                return@runBlocking fakeSessionReaderImpl.isActiveSession()
            }

        assertFalse(result)
    }

    @Test
    fun `SessionReaderImpl returns true when active session API returns Success`() {
        sessionApi.setActiveSession(
            ApiResponse.Success(true),
        )

        val sessionReader =
            SessionReaderImpl(
                sessionApi = sessionApi,
            )

        val result =
            runBlocking {
                return@runBlocking sessionReader.isActiveSession()
            }

        assertTrue(result)
    }
}
