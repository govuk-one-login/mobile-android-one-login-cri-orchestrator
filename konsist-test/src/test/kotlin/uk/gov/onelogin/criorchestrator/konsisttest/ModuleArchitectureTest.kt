package uk.gov.onelogin.criorchestrator.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.Konsist.scopeFromTest
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.jupiter.api.Test
import uk.gov.onelogin.criorchestrator.konsisttest.filters.hasPackageMatching
import uk.gov.onelogin.criorchestrator.konsisttest.filters.withPackageMatching
import uk.gov.onelogin.criorchestrator.konsisttest.scopes.defaultScope

class ModuleArchitectureTest {
    companion object {
        private val libraryPackage = """uk\.gov\..*\.libraries\..*""".toRegex()
        private val featurePackageAny =
            """(uk\.gov\..*\.features\..*)\.(?:internal|internalapi|publicapi|)(?:\..*|$)""".toRegex()
        private val featurePackageInternal =
            """(uk\.gov\..*\.features\..*)\.internal(?:\..*|$)""".toRegex()
        private val featurePackageApi =
            """(uk\.gov\..*\.features\..*)\.(:?internalapi|publicapi)(?:\..*|$)""".toRegex()
    }

    @Test
    fun `feature modules have valid package names`() {
        val potentialFeaturePackage =
            "uk\\.gov\\..*\\.features\\..*".toRegex()
        Konsist
            .defaultScope()
            .files
            .withPackageMatching(potentialFeaturePackage)
            .assertTrue {
                it.hasPackageMatching(featurePackageAny)
            }

    }

    @Test
    fun `feature modules do not depend directly on other features internals`() {
        Konsist
            .defaultScope()
            .minus(scope = scopeFromTest())
            .files
            .withPackageMatching(featurePackageAny)
            .assertTrue(
                additionalMessage = """
                    Features should depend on each other indirectly, through API modules.
                    Implementations should be injected.
                    """.trimIndent()
            ) {
                val thisFeaturePackage =
                    featurePackageAny.find(it.packagee!!.text)!!.groupValues[1]
                it.imports.filter {
                    !it.hasNameStartingWith(thisFeaturePackage)
                }.none {
                    it.hasNameMatching(featurePackageInternal)
                }
            }
    }

    @Test
    fun `api modules do not contain implementations`() {
        Konsist
            .defaultScope()
            .minus(scope = scopeFromTest())
            .files
            .withPackageMatching(featurePackageApi)
            .assertTrue {
                it.classes()
                    .all { it.hasDataModifier || it.hasEnumModifier }
            }
    }

    @Test
    fun `library modules do not depend on feature modules`() {
        Konsist
            .defaultScope()
            .files
            .withPackageMatching(libraryPackage)
            .assertTrue {
                it.imports.none {
                    it.hasNameMatching(featurePackageAny)
                }
            }
    }
}
