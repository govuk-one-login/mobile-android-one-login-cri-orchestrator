package uk.gov.onelogin.criorchestrator.features.config.publicapi

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uk.gov.logging.api.LogTagProvider
import uk.gov.logging.api.Logger

class InMemoryConfigStore(
    private val logger: Logger,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : ConfigStore,
    LogTagProvider {
    private val _keyValueMapStateFlow: MutableStateFlow<Map<String, Any>> =
        MutableStateFlow<Map<String, Any>>(
            mapOf(),
        )

    override val keyValueMapStateFlow: StateFlow<Map<String, Any>>
        get() = _keyValueMapStateFlow.asStateFlow()

    // function that creates flow for value associated with given key to only get single value and
    // only update when that value is updated

    // Be able to write single value

    // simplify naming config read and write
    override fun writeProvidedConfig(configMap: Map<String, Any>) {
        logger.debug(
            tag,
            "Config Store writeProvidedConfig called",
        )
        val updatedMap = _keyValueMapStateFlow.value.toMutableMap()
        for ((key, value) in configMap) {
            updatedMap[key] = value
        }
        logger.debug(
            tag,
            "Config Store Writing sets of keys ${updatedMap.keys} with sets " +
                "of values ${updatedMap.values}",
        )
        CoroutineScope(dispatcher).launch {
            _keyValueMapStateFlow.value = updatedMap
            logger.debug(
                tag,
                "Config Store emitted updated map $updatedMap",
            )
        }
    }
}
