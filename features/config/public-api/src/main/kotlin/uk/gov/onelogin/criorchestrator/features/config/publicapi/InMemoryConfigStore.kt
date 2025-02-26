package uk.gov.onelogin.criorchestrator.features.config.publicapi

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import uk.gov.logging.api.LogTagProvider
import uk.gov.logging.api.Logger

class InMemoryConfigStore(
    private val logger: Logger,
) : ConfigStore,
    LogTagProvider {
        // Could be mutable state flow on config data class
        //
    private val keyValueMap: MutableMap<String, MutableStateFlow<Any>> = mutableMapOf()

    override fun read(key: String): StateFlow<Any> = keyValueMap.getValue(key).asStateFlow()

    override fun write(configMap: Map<String, Any>) {
        for ((key, value) in configMap) {
            keyValueMap.getOrPut(key, { createStateFlow(value) }).value = value
        }
        logger.debug(
            tag,
            "Config Store Written sets of keys ${keyValueMap.keys} with sets " +
                "of values ${keyValueMap.values}",
        )
    }

    fun createStateFlow(value: Any): MutableStateFlow<Any> = MutableStateFlow<Any>(value)
}
