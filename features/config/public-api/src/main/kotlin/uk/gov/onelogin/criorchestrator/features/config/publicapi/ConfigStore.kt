package uk.gov.onelogin.criorchestrator.features.config.publicapi

import kotlinx.coroutines.flow.StateFlow

interface ConfigStore {
    val keyValueMapStateFlow: StateFlow<Map<String, Any>>

    fun writeProvidedConfig(configProvider: ConfigProvider)
}
