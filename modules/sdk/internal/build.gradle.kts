plugins {
    listOf(
        "uk.gov.onelogin.criorchestrator.android-lib-config",
    ).forEach {
        id(it)
    }
}

dependencies {
    listOf(
        libs.uk.gov.networking,
        project(":modules:sdk:shared-api"),
        project(":modules:features:resume:internal"),
        project(":modules:features:resume:internal-api"),
        project(":modules:features:resume:public-api"),
    ).forEach {
        implementation(it)
    }
}

mavenPublishingConfig {
    mavenConfigBlock {
        name.set(
            "GOV.UK One Login CRI Orchestrator SDK Internal",
        )
        description.set(
            """
            The Credential Issuer (CRI) Orchestrator SDK Internal module contains the real Dagger
            component used for the CRI Orchestrator SDK, and functions to instantiate it.
            """.trimIndent(),
        )
    }
}
