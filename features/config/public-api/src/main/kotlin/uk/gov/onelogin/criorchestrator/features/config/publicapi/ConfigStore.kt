package uk.gov.onelogin.criorchestrator.features.config.publicapi

import kotlinx.coroutines.flow.StateFlow

interface ConfigStore {
    fun read(key: String): StateFlow<Any>

    fun write(config: Map<String, Any>)
}
