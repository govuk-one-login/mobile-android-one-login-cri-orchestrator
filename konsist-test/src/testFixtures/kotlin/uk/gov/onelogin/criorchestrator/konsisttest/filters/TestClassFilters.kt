package uk.gov.onelogin.criorchestrator.konsisttest.filters

import com.lemonappdev.konsist.api.provider.KoAnnotationProvider
import com.lemonappdev.konsist.api.provider.KoClassAndObjectProvider

const val TEST_CLASS_NAME_SUFFIX = "Test"
const val SCREENSHOT_TEST_CLASS_NAME_SUFFIX = "ScreenshotTest"

fun <T : KoClassAndObjectProvider> List<T>.withUnitTestClass() =
    filter {
        it.hasClassOrObject { cls ->
            cls.hasNameEndingWith(TEST_CLASS_NAME_SUFFIX) &&
                !cls.hasNameEndingWith(SCREENSHOT_TEST_CLASS_NAME_SUFFIX) &&
                !cls.hasRunWithAndroidJUnitRunnerAnnotation()
        }
    }

fun <T : KoClassAndObjectProvider> List<T>.withUiTestClass() =
    filter {
        it.hasClassOrObject { cls ->
            cls.hasRunWithAndroidJUnitRunnerAnnotation()
        }
    }

fun <T : KoClassAndObjectProvider> List<T>.withScreenshotTestClass() =
    filter {
        it.hasClassOrObject { cls ->
            cls.hasNameEndingWith(SCREENSHOT_TEST_CLASS_NAME_SUFFIX)
        }
    }

private fun <T : KoAnnotationProvider> T.hasRunWithAndroidJUnitRunnerAnnotation(): Boolean =
    hasAnnotation {
        it.name == "RunWith" && it.hasArgument { it.value == "AndroidJUnit4::class" }
    }
