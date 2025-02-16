package uk.gov.onelogin.criorchestrator.features.session.internal

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import uk.gov.android.network.api.ApiResponse

class DefaultGetActiveSessionUseCaseTest {
    private val fakeSessionStore = fakeSessionStore()
    val fakeSessionApiImpl = FakeSessionApiImpl()

    @Test
    fun `DefaultGetActiveSessionUseCase returns false when active session API returns Failure`() {
        fakeSessionApiImpl.setActiveSession(
            ApiResponse.Failure(
                status = 0,
                error = Exception("test exception"),
            ),
        )

        val fakeDefaultGetActiveSessionUseCase =
            DefaultGetActiveSessionUseCase(
                sessionApi = fakeSessionApiImpl,
                sessionStore = fakeSessionStore,
            )

        val result =
            runBlocking {
                return@runBlocking fakeDefaultGetActiveSessionUseCase.execute()
            }

        assertFalse(result)
    }

    @Test
    fun `DefaultGetActiveSessionUseCase returns false when active session API returns Loading`() {
        fakeSessionApiImpl.setActiveSession(
            ApiResponse.Loading,
        )

        val fakeDefaultGetActiveSessionUseCase =
            DefaultGetActiveSessionUseCase(
                sessionApi = fakeSessionApiImpl,
                sessionStore = fakeSessionStore,
            )

        val result =
            runBlocking {
                return@runBlocking fakeDefaultGetActiveSessionUseCase.execute()
            }

        assertFalse(result)
    }

    @Test
    fun `DefaultGetActiveSessionUseCase returns false when active session API returns Offline`() {
        fakeSessionApiImpl.setActiveSession(
            ApiResponse.Offline,
        )

        val fakeDefaultGetActiveSessionUseCase =
            DefaultGetActiveSessionUseCase(
                sessionApi = fakeSessionApiImpl,
                sessionStore = fakeSessionStore,
            )

        val result =
            runBlocking {
                return@runBlocking fakeDefaultGetActiveSessionUseCase.execute()
            }

        assertFalse(result)
    }

    @Test
    fun `DefaultGetActiveSessionUseCase returns true when active session API returns Success`() {
        fakeSessionApiImpl.setActiveSession(
            ApiResponse.Success(true),
        )

        val fakeDefaultGetActiveSessionUseCase =
            DefaultGetActiveSessionUseCase(
                sessionApi = fakeSessionApiImpl,
                sessionStore = fakeSessionStore,
            )

        val result =
            runBlocking {
                return@runBlocking fakeDefaultGetActiveSessionUseCase.execute()
            }

        assertTrue(result)
    }
}
