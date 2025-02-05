package uk.gov.onelogin.criorchestrator.libraries.androidutils

import android.content.Context
import androidx.annotation.StringRes
import com.squareup.anvil.annotations.ContributesBinding
import uk.gov.logging.api.analytics.extensions.getEnglishString
import uk.gov.onelogin.criorchestrator.libraries.di.CriOrchestratorScope
import javax.inject.Inject

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

@ContributesBinding(CriOrchestratorScope::class)
class AndroidResourceProvider
    @Inject
    constructor(
        private val context: Context,
    ) : ResourceProvider {
        override fun getEnglishString(
            @StringRes resId: Int,
        ): String = context.getEnglishString(resId)
    }
