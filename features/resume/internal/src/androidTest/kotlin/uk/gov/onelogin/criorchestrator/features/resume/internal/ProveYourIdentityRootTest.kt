package uk.gov.onelogin.criorchestrator.features.resume.internal

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.core.app.ApplicationProvider
import org.junit.Rule
import org.junit.Test
import uk.gov.logging.testdouble.analytics.FakeAnalyticsLogger

class ProveYourIdentityRootTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    val fakeResourceProvider by lazy {
        AndroidResourceProvider(
            ApplicationProvider.getApplicationContext(),
        )
    }

    private val fakeViewModel =
        ProveYourIdentityViewModel(
            analyticsLogger = FakeAnalyticsLogger(),
            resourceProvider = fakeResourceProvider,
        )

    @Test
    fun displaysIntendedUiElement() {
        composeTestRule.setContent {
            ProveYourIdentityRoot(
                fakeViewModel,
            )
        }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag(PROVE_YOUR_IDENTITY_UI_CARD_TEST_TAG).assertIsDisplayed()
    }
}
