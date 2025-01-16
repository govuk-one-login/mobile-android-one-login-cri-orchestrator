import com.android.build.api.dsl.LibraryExtension
import uk.gov.onelogin.criorchestrator.extensions.setNamespace

plugins {
    listOf(
        "uk.gov.onelogin.criorchestrator.android-lib-config",
        "uk.gov.onelogin.criorchestrator.networking-config",
    ).forEach {
        id(it)
    }
}

configure<LibraryExtension> {
    setNamespace(suffix = ".sdk.internal")
}

dependencies {
    listOf(
        ":modules:libraries:di",
        ":modules:sdk:shared-api",
    ).forEach {
        implementation(project(it))
    }
}

// TODO(DCMAW-10843): write meaningful description
mavenPublishingConfig {
    mavenConfigBlock {
        name.set(
            "GOV.UK One Login CRI Orchestrator SDK Internal",
        )
        description.set(
            """
            The Credential Issuer (CRI) Orchestrator coordinates identity proofing capability.
            """.trimIndent(),
        )
    }
}
