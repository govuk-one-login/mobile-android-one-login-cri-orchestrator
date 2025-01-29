package uk.gov.onelogin.criorchestrator.konsisttest.filters

import com.lemonappdev.konsist.api.provider.KoClassAndObjectProvider

const val TEST_CLASS_NAME_SUFFIX = "Test"
const val SCREENSHOT_TEST_CLASS_NAME_SUFFIX = "ScreenshotTest"

fun <T : KoClassAndObjectProvider> List<T>.withUnitTestClass() =
    filter {
        it.hasClassOrObject { cls ->
            cls.hasNameEndingWith(TEST_CLASS_NAME_SUFFIX) &&
                !cls.hasNameEndingWith(SCREENSHOT_TEST_CLASS_NAME_SUFFIX)
        }
    }

fun <T : KoClassAndObjectProvider> List<T>.withScreenshotTestClass() =
    filter {
        it.hasClassOrObject { cls ->
            cls.hasNameEndingWith(SCREENSHOT_TEST_CLASS_NAME_SUFFIX)
        }
    }
