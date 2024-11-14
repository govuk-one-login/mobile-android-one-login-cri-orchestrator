package uk.gov.onelogin.criorchestrator

listOf(
    "uk.gov.pipelines.detekt-config",
    "uk.gov.pipelines.ktlint-config",
).forEach {
    project.plugins.apply(it)
}
