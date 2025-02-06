package uk.gov.onelogin.criorchestrator.libraries.androidutils.resources

import androidx.annotation.StringRes

/**
 * Interface for providing resources.
 */
fun interface ResourceProvider {
    /**
     * Function that returns the English versions of strings for non-user-facing usage,
     * typically for analytics.
     */
    fun getEnglishString(
        @StringRes resId: Int,
    ): String
}
