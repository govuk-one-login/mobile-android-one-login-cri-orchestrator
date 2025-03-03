package uk.gov.onelogin.criorchestrator.features.config.internal

import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull
import uk.gov.logging.api.LogTagProvider
import uk.gov.logging.api.Logger
import uk.gov.onelogin.criorchestrator.features.config.publicapi.Config
import uk.gov.onelogin.criorchestrator.features.config.publicapi.ConfigKey
import uk.gov.onelogin.criorchestrator.features.config.publicapi.ConfigStore
import uk.gov.onelogin.criorchestrator.libraries.di.scopes.CriOrchestratorScope
import javax.inject.Inject

@ContributesBinding(CriOrchestratorScope::class, boundType = ConfigStore::class)
class InMemoryConfigStore
    @Inject
    constructor(
        private val logger: Logger,
        initialConfig: Config,
    ) : ConfigStore,
        LogTagProvider {
        private val config: MutableStateFlow<Config> = MutableStateFlow(initialConfig)

        override fun <T : Config.Value> read(key: ConfigKey<T>): Flow<T> =
            config
                .mapNotNull {
                    val item = it.entries.find { it.key == key }
                    return@mapNotNull if (item == null) {
                        throw NoSuchElementException("key: ${key.javaClass.simpleName}")
                    } else {
                        item.value as T
                    }
                }.distinctUntilChanged()

        override fun writeAll(config: Config) {
            this.config.value = this.config.value.combinedWith(config)

            logger.debug(
                tag,
                "Wrote config: $config",
            )
        }

        override fun <T : Config.Value> write(entry: Config.Entry<T>) =
            writeAll(
                Config(
                    entries = persistentListOf(entry),
                ),
            )
    }
