package uk.gov.onelogin.criorchestrator.features.config.publicapi

object StubConfig {
    const val BACKEND_ASYNC_URL_TEST_VALUE = "https://test.backend.url"

    fun provideConfig() =
        ConfigProvider(
            backendAsyncUrl = BACKEND_ASYNC_URL_TEST_VALUE,
        )
}
