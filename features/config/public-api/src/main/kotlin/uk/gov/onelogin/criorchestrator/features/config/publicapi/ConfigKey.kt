package uk.gov.onelogin.criorchestrator.features.config.publicapi

/**
 * Base class for configuration keys.
 *
 * @property name The human readable name for this configuration item
 */
abstract class ConfigKey<T : Config.Value>(
    val name: String,
)
