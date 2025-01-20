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
    setNamespace(suffix = ".resume.internalapi")
}

dependencies {
    implementation(project(":modules:libraries:di"))
}

mavenPublishingConfig {
    mavenConfigBlock {
        name.set(
            "GOV.UK One Login CRI Orchestrator Start ID Check Card Internal API",
        )
        description.set(
            """
            The Start ID Check Card Internal API module contains the interface used for Start ID
            Check UI component entry points.
            """.trimIndent(),
        )
    }
}
