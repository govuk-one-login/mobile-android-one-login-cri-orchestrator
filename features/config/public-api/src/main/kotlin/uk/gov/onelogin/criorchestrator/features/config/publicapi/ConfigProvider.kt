package uk.gov.onelogin.criorchestrator.features.config.publicapi

data class ConfigProvider(
    val backendAsyncUrl: String,
)

sealed class ConfigField {
    object BackendAsyncUrl : ConfigField()
}
