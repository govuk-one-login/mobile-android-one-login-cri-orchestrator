package uk.gov.onelogin.criorchestrator.testwrapper

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.fail
import org.junit.Test
import org.junit.runner.RunWith

/**
 * This test is needed due to a a bug in `mobile-android-pipelines` requiring
 * all modules reporting test coverage at least one test in each of `test` and
 * `androidTest` source sets.
 */
@RunWith(AndroidJUnit4::class)
class PlaceholderInstrumentationTest {
    @Test
    fun placeholder() {
        fail("There are no device tests in this module")
    }
}
