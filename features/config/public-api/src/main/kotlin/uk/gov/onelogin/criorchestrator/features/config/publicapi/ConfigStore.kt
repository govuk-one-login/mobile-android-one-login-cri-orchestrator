package uk.gov.onelogin.criorchestrator.features.config.publicapi

import kotlinx.coroutines.flow.StateFlow

interface ConfigStore {
    fun read(key: ConfigField): StateFlow<Any>

    fun write(config: ConfigProvider)
}
