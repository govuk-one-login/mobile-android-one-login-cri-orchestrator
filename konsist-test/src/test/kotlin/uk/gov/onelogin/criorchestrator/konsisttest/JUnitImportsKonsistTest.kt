package uk.gov.onelogin.criorchestrator.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.jupiter.api.Test
import uk.gov.onelogin.criorchestrator.konsisttest.filters.doesNotImportJUnit4
import uk.gov.onelogin.criorchestrator.konsisttest.filters.doesNotImportJUnit5
import uk.gov.onelogin.criorchestrator.konsisttest.filters.withAndroidTestSourceSet
import uk.gov.onelogin.criorchestrator.konsisttest.filters.withScreenshotTestClass
import uk.gov.onelogin.criorchestrator.konsisttest.filters.withTestSourceSet
import uk.gov.onelogin.criorchestrator.konsisttest.filters.withUnitTestClass
import uk.gov.onelogin.criorchestrator.konsisttest.scopes.defaultScope

class JUnitImportsKonsistTest {
    @Test
    fun `unit tests do not use JUnit 4`() {
        Konsist
            .defaultScope()
            .files
            .withTestSourceSet()
            .withUnitTestClass()
            .assertTrue {
                it.doesNotImportJUnit4()
            }
    }

    @Test
    fun `screenshot tests do not use JUnit 5`() {
        Konsist
            .defaultScope()
            .files
            .withTestSourceSet()
            .withScreenshotTestClass()
            .assertTrue {
                it.doesNotImportJUnit5()
            }
    }

    @Test
    fun `android tests do not use JUnit 5`() {
        Konsist
            .defaultScope()
            .files
            .withAndroidTestSourceSet()
            .assertTrue {
                it.doesNotImportJUnit5()
            }
    }
}
