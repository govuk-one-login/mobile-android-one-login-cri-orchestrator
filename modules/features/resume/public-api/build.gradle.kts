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

configure<LibraryExtension> {
    setNamespace(suffix = ".features.resume.publicapi")
}

dependencies {
    listOf(
        project(":modules:sdk:shared-api"),
        project(":modules:features:resume:internal-api"),
    ).forEach {
        api(it)
    }
}

mavenPublishingConfig {
    mavenConfigBlock {
        name.set(
            "GOV.UK One Login CRI Orchestrator Start ID Check Card Public API",
        )
        description.set(
            """
            The Start ID Check Card Public API module contains the Compose composable that functions
            as the single touchpoint between the consuming app and the Start ID Check Card feature.
            """.trimIndent(),
        )
    }
}
