package uk.gov.onelogin.criorchestrator.features.session.internal

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import uk.gov.android.network.api.ApiResponse
import uk.gov.logging.testdouble.SystemLogger
import uk.gov.onelogin.criorchestrator.features.session.internal.network.RemoteSessionReader

class RemoteSessionReaderTest {
    val sessionApi = StubSessionApiImpl()
    val logger = SystemLogger()

    @Test
    fun `Session reader returns false with expected log when active session API returns Failure`() =
        runTest {
            sessionApi.setActiveSession(
                ApiResponse.Failure(
                    status = 401,
                    error = Exception("test exception"),
                ),
            )

            val remoteSessionReader =
                RemoteSessionReader(
                    sessionApi = sessionApi,
                    logger = logger,
                )

            val result = remoteSessionReader.isActiveSession()

            assertTrue(logger.contains("Failed to fetch active session"))
            assertFalse(result)
        }

    @Test
    fun `Session reader returns false with expected log when active session API returns Loading`() =
        runTest {
            sessionApi.setActiveSession(
                ApiResponse.Loading,
            )

            val remoteSessionReader =
                RemoteSessionReader(
                    sessionApi = sessionApi,
                    logger = logger,
                )

            val result = remoteSessionReader.isActiveSession()

            assertFalse(result)
        }

    @Test
    fun `Session reader returns false with expected log when active session API returns Offline`() =
        runTest {
            sessionApi.setActiveSession(
                ApiResponse.Offline,
            )

            val remoteSessionReader =
                RemoteSessionReader(
                    sessionApi = sessionApi,
                    logger = logger,
                )

            val result = remoteSessionReader.isActiveSession()

            assertTrue(logger.contains("Failed to fetch active session - device is offline"))
            assertFalse(result)
        }

    // This test will also fail if the serialization plugin isn't applied
    @Test
    fun `Session reader returns true with expected log when active session API returns Success`() =
        runTest {
            sessionApi.setActiveSession(
                ApiResponse.Success<String>(
                    """
                    {
                        "sessionId": "test session ID",
                        "redirectUri": "https://example/redirect",
                        "state": "11112222333344445555666677778888"
                    }
                    """.trimIndent(),
                ),
            )

            val sessionReader =
                RemoteSessionReader(
                    sessionApi = sessionApi,
                    logger = logger,
                )

            val result = sessionReader.isActiveSession()

            assertTrue(logger.contains("Got active session: id=test session ID"))
            assertTrue(result)
        }

    @Test
    fun `Session reader returns false with expected log when response parsed incorrectly`() =
        runTest {
            sessionApi.setActiveSession(
                ApiResponse.Success<String>(
                    """
                    {
                        "sessionId_WRONG": "test session ID",
                        "redirectUri": "https://example/redirect",
                        "state": "11112222333344445555666677778888"
                    }
                    """.trimIndent(),
                ),
            )

            val sessionReader =
                RemoteSessionReader(
                    sessionApi = sessionApi,
                    logger = logger,
                )

            val result = sessionReader.isActiveSession()

            assertTrue(logger.contains("Failed to parse active session response"))
            assertFalse(result)
        }
}
