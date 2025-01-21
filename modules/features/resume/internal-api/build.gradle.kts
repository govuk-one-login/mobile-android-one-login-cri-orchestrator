import com.android.build.api.dsl.LibraryExtension
import uk.gov.onelogin.criorchestrator.extensions.setNamespace

plugins {
    listOf(
        "uk.gov.onelogin.criorchestrator.android-lib-config",
        "uk.gov.onelogin.criorchestrator.base-compose-config",
    ).forEach {
        id(it)
    }
}

configure<LibraryExtension> {
    setNamespace(suffix = ".features.resume.internalapi")
}

dependencies {
    implementation(project(":modules:libraries:di"))
}

mavenPublishingConfig {
    mavenConfigBlock {
        name.set(
            "GOV.UK One Login CRI Orchestrator Resume ID Check Card Internal API",
        )
        description.set(
            """
            The Resume ID Check Card Internal API module contains the interface used for Resume ID
            Check UI component entry points.
            """.trimIndent(),
        )
    }
}
