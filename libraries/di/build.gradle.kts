import uk.gov.onelogin.criorchestrator.extensions.customisePublications

plugins {
    id("uk.gov.onelogin.criorchestrator.kotlin-lib-config")
}

configure<PublishingExtension> {
    customisePublications {
        artifactId = "di"
    }
}

dependencies {
    implementation(libs.dagger)
}

mavenPublishingConfig {
    mavenConfigBlock {
        name.set(
            "GOV.UK One Login CRI Orchestrator Dependency Injection Module",
        )
        description.set(
            """
            The Credential Issuer (CRI) Orchestrator Dependency Injection Module contains dependency
            injection scopes used by Dagger and Anvil.
            """.trimIndent(),
        )
    }
}
