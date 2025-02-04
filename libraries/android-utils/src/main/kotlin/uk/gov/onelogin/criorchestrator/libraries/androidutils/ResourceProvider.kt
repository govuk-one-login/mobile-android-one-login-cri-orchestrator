package uk.gov.onelogin.criorchestrator.libraries.androidutils

import androidx.annotation.StringRes

/**
 * Interface for providing English string resources.
 */
fun interface ResourceProvider {
    fun getEnglishString(
        @StringRes resId: Int,
    ): String
}
