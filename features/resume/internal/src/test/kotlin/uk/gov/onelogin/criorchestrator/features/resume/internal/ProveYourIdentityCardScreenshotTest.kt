package uk.gov.onelogin.criorchestrator.features.resume.internal

import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class ProveYourIdentityCardScreenshotTest {
    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun launchComposable() {
        paparazzi.snapshot {
            ProveYourIdentityUiCard()
        }
    }
}
