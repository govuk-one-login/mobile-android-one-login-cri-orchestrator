package uk.gov.onelogin.criorchestrator.features.session.internal

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import uk.gov.android.network.api.ApiResponse
import uk.gov.logging.testdouble.SystemLogger
import uk.gov.onelogin.criorchestrator.features.session.internal.network.RemoteSessionReader

class RemoteSessionReaderTest {
    val sessionApi = StubSessionApiImpl()

    @Test
    fun `SessionReaderImpl returns false when active session API returns Failure`() {
        sessionApi.setActiveSession(
            ApiResponse.Failure(
                status = 0,
                error = Exception("test exception"),
            ),
        )

        val remoteSessionReader =
            RemoteSessionReader(
                sessionApi = sessionApi,
                logger = SystemLogger(),
            )

        val result =
            runBlocking {
                return@runBlocking remoteSessionReader.isActiveSession()
            }

        assertFalse(result)
    }

    @Test
    fun `SessionReaderImpl returns false when active session API returns Loading`() {
        sessionApi.setActiveSession(
            ApiResponse.Loading,
        )

        val remoteSessionReader =
            RemoteSessionReader(
                sessionApi = sessionApi,
                logger = SystemLogger(),
            )

        val result =
            runBlocking {
                return@runBlocking remoteSessionReader.isActiveSession()
            }

        assertFalse(result)
    }

    @Test
    fun `SessionReaderImpl returns false when active session API returns Offline`() {
        sessionApi.setActiveSession(
            ApiResponse.Offline,
        )

        val remoteSessionReader =
            RemoteSessionReader(
                sessionApi = sessionApi,
                logger = SystemLogger(),
            )

        val result =
            runBlocking {
                return@runBlocking remoteSessionReader.isActiveSession()
            }

        assertFalse(result)
    }

    @Test
    fun `SessionReaderImpl returns true when active session API returns Success`() {
        sessionApi.setActiveSession(
            ApiResponse.Success(true),
        )

        val sessionReader =
            RemoteSessionReader(
                sessionApi = sessionApi,
                logger = SystemLogger(),
            )

        val result =
            runBlocking {
                return@runBlocking sessionReader.isActiveSession()
            }

        assertTrue(result)
    }
}
