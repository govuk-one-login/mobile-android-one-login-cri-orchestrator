plugins {
    listOf(
        "uk.gov.onelogin.criorchestrator.android-lib-config",
        "uk.gov.onelogin.criorchestrator.base-compose-config",
    ).forEach {
        id(it)
    }
}

dependencies {
    listOf(
        libs.uk.gov.networking,
        project(":sdk:internal"),
    ).forEach {
        implementation(it)
    }

    listOf(
        project(":sdk:shared-api"),
        project(":features:resume:public-api"),
    ).forEach {
        api(it)
    }
}

mavenPublishingConfig {
    mavenConfigBlock {
        name.set(
            "GOV.UK One Login CRI Orchestrator SDK Public API",
        )
        description.set(
            """
            The Credential Issuer (CRI) Orchestrator coordinates identity proofing capability.
            This module contains the public API used to interface with the CRI Orchestrator
            """.trimIndent(),
        )
    }
}
