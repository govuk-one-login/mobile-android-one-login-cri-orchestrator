package uk.gov.onelogin.criorchestrator.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withParent
import com.lemonappdev.konsist.api.ext.list.withProperty
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.jupiter.api.Test
import uk.gov.onelogin.criorchestrator.konsisttest.filters.SCREENSHOT_TEST_CLASS_NAME_SUFFIX
import uk.gov.onelogin.criorchestrator.konsisttest.scopes.defaultScope

class ScreenshotTestKonsistTest {
    @Test
    fun `screenshot tests use ScreenshotTest suffix`() {
        Konsist
            .defaultScope()
            .classes()
            .withProperty {
                it.hasNameStartingWith("paparazzi")
            }.assertTrue {
                it.hasNameEndingWith(SCREENSHOT_TEST_CLASS_NAME_SUFFIX)
            }
    }

    @Test
    fun `screenshot test subclasses use ScreenshotTest suffix`() {
        Konsist
            .defaultScope()
            .classes()
            .withParent {
                it.hasNameEndingWith(SCREENSHOT_TEST_CLASS_NAME_SUFFIX)
            }.assertTrue {
                it.hasNameEndingWith(SCREENSHOT_TEST_CLASS_NAME_SUFFIX)
            }
    }
}
