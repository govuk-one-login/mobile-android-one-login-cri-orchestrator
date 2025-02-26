package uk.gov.onelogin.criorchestrator.konsisttest

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.Konsist.scopeFromTest
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.jupiter.api.Test
import uk.gov.onelogin.criorchestrator.konsisttest.scopes.defaultScope

class ModuleArchitectureTest {
    companion object {
        private val libraryPackage = """uk\.gov\..*\.libraries\..*""".toRegex()
        private val featurePackage =
            """(uk\.gov\..*\.features\..*)\.(?:internal|internalapi|publicapi|)(?:\..*|$)""".toRegex()
        private val featureInternalPackage =
            """(uk\.gov\..*\.features\..*)\.internal(?:\..*|$)""".toRegex()
        private val featureApiPackage =
            """(uk\.gov\..*\.features\..*)\.(:?internalapi|publicapi)(?:\..*|$)""".toRegex()
    }

    @Test
    fun `feature modules have valid package names`() {
        val potentialFeaturePackage =
            "uk\\.gov\\..*\\.features\\..*".toRegex()
        Konsist
            .defaultScope()
            .files
            .filter {
                it.packagee?.hasNameMatching(potentialFeaturePackage) == true
            }
            .assertTrue {
                it.packagee!!.hasNameMatching(featurePackage)
            }

    }

    @Test
    fun `feature modules do not depend directly on other features internals`() {
        Konsist
            .defaultScope()
            .minus(scope = scopeFromTest())
            .files
            .filter {
                it.packagee?.hasNameMatching(featurePackage) == true
            }
            .assertTrue(
                additionalMessage = """
                    Features should depend on each other indirectly, through API modules.
                    Implementations should be injected.
                    """.trimIndent()
            ) {
                val thisFeaturePackage =
                    featurePackage.find(it.packagee!!.text)!!.groupValues[1]
                it.imports.filter {
                    !it.hasNameStartingWith(thisFeaturePackage)
                }.none {
                    it.hasNameMatching(featureInternalPackage)
                }
            }
    }

    @Test
    fun `api modules do not contain implementations`() {
        Konsist
            .defaultScope()
            .minus(scope = scopeFromTest())
            .files
            .filter {
                it.packagee?.hasNameMatching(featureApiPackage) == true
            }
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
            .filter {
                it.packagee?.hasNameMatching(libraryPackage) == true
            }
            .assertTrue {
                it.imports.none {
                    it.hasNameMatching(featurePackage)
                }
            }
    }
}
