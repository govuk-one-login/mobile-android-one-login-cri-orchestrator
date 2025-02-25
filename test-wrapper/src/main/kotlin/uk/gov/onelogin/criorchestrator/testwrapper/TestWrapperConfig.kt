package uk.gov.onelogin.criorchestrator.testwrapper

import android.content.res.Resources

object TestWrapperConfig {
    fun provideConfig(resources: Resources) = mutableMapOf<String, Any>(
            "backendAsyncUrl" to resources.getString(R.string.backendAsyncUrl),
        )
}
