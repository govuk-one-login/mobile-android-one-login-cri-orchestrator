package uk.gov.onelogin.criorchestrator.features.resume.internal

import android.content.Context
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProveYourIdentityUiCardTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var primaryButton: SemanticsMatcher

    @Before
    fun setUp() {
        val context: Context = ApplicationProvider.getApplicationContext()
        primaryButton = hasText(context.getString(R.string.start_id_check_primary_button))
    }

    @Test
    fun onClick() {
        var didClick = false

        composeTestRule.setContent {
            ProveYourIdentityUiCard(onStartClick = {
                didClick = true
            })
        }

        composeTestRule.onNode(primaryButton).performClick()

        assert(didClick)
    }
}
