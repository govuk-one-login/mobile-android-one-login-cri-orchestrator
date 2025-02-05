package uk.gov.onelogin.criorchestrator.features.resume.internal

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import uk.gov.onelogin.criorchestrator.features.resume.internal.test.R as testR

@RunWith(AndroidJUnit4::class)
class AndroidResourceProviderTest {
    val context: Context = ApplicationProvider.getApplicationContext()
    val testAndroidResourceProvider = AndroidResourceProvider(context)

    @Test
    fun test() {
        val expectedString = "test string"
        // Even though it looks like it can't resolve the string, when the test runs it resolves.
        val testString = testAndroidResourceProvider.getEnglishString(testR.string.test_string)
        assertEquals(expectedString, testString)
    }
}
