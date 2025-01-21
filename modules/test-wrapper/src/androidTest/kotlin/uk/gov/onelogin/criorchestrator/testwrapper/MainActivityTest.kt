package uk.gov.onelogin.criorchestrator.testwrapper

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun itLaunches() {
        launchActivity<MainActivity>().use {
            onView(withId(android.R.id.content))
                .check(matches(isDisplayed()))
        }
    }

    @Test
    fun previewTest() {
        composeTestRule.setContent {
            HelloWorldPreview()
        }
    }
}
