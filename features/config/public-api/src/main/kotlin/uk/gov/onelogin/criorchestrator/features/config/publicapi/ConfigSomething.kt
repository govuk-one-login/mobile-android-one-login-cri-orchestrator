package uk.gov.onelogin.criorchestrator.features.config.publicapi

import kotlinx.coroutines.flow.StateFlow


data class ConfigSomething(
    val url: String,
    val feature1: Boolean = false
)