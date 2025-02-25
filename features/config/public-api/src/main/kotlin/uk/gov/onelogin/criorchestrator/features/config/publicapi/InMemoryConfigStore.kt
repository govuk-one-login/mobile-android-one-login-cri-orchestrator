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

    override fun writeProvidedConfig(configProvider: ConfigProvider) {
        logger.debug(
            tag,
            "Config Store writeProvidedConfig called",
        )
        val updatedMap = _keyValueMapStateFlow.value.toMutableMap()
        for ((key, value) in configProvider.configMap) {
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
