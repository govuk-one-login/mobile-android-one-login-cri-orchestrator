package uk.gov.onelogin.criorchestrator.features.config.publicapi

object StubConfig {
    const val BACKEND_ASYNC_URL_TEST_KEY = "backendAsyncUrl"
    const val BACKEND_ASYNC_URL_TEST_VALUE = "https://test.backend.url"

    fun provideConfig() =
        mutableMapOf(
            BACKEND_ASYNC_URL_TEST_KEY to BACKEND_ASYNC_URL_TEST_VALUE,
        )
}
