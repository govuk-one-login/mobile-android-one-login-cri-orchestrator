package uk.gov.onelogin.criorchestrator.features.session.internal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InMemorySessionStoreTest {
    private val sessionStore = InMemorySessionStore()

    @Test
    fun `session store reads default value of false`() {
        val result = sessionStore.read().value
        assertEquals(false, result)
    }

    @Test
    fun `session store can read the written value`() {
        sessionStore.write(true)
        val result = sessionStore.read().value
        assertEquals(true, result)
    }
}
