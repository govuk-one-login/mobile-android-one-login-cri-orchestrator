package uk.gov.onelogin.criorchestrator.libraries.androidutils

import androidx.annotation.StringRes

fun interface ResourceProvider {
    fun getEnglishString(
        @StringRes resId: Int,
    ): String
}
