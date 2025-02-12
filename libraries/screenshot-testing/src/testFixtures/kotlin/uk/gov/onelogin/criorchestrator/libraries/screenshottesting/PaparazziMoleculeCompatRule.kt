package uk.gov.onelogin.criorchestrator.libraries.screenshottesting

import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams.RenderingMode.SHRINK
import org.junit.rules.TestRule

/**
 * Creates a test rule that works around a compatibility issue between Molecule and Paparazzi.
 *
 * Use this test rule in tests using Molecule that live alongside Paparazzi screenshot tests.
 *
 * At the point at that this rule can be removed or Paparazzi supports JUnit 5, Molecule tests
 * can be converted back to JUnit 5.
 *
 * ## Related issues
 *
 * - https://github.com/cashapp/molecule/issues/321
 * - https://github.com/cashapp/paparazzi/issues/1149
 * - https://issuetracker.google.com/issues/375395107#comment2
 */
fun createMoleculePaparazziCompatRule(): TestRule =
    Paparazzi(
        renderingMode = SHRINK,
        showSystemUi = false,
    )
