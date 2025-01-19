import com.android.build.api.dsl.LibraryExtension
import uk.gov.onelogin.criorchestrator.extensions.setNamespace

plugins {
    listOf(
        "uk.gov.onelogin.criorchestrator.android-lib-config",
        "uk.gov.onelogin.criorchestrator.ui-config",
    ).forEach {
        id(it)
    }
}
dependencies {
    listOf(
        project(":modules:sdk:shared-api"),
        project(":modules:features:start-idcheck-card:internal-api"),
    ).forEach {
        api(it)
    }
}

configure<LibraryExtension> {
    setNamespace(suffix = ".startidcheckcard.publicapi")
}

// TODO: DCMAW-10843 write meaningful description
mavenPublishingConfig {
    mavenConfigBlock {
        name.set(
            "GOV.UK One Login CRI Orchestrator Start ID Check Card Public API",
        )
        description.set(
            """
            """.trimIndent(),
        )
    }
}
