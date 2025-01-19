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
    setNamespace(suffix = ".startidcheckcard.internal")
}

dependencies {
    listOf(
        project(":modules:libraries:di"),
        project(":modules:features:start-idcheck-card:public-api"),
    ).forEach {
        implementation(it)
    }
}

// TODO: DCMAW-10843 write meaningful description
mavenPublishingConfig {
    mavenConfigBlock {
        name.set(
            "GOV.UK One Login CRI Orchestrator Start ID Check Card Internal",
        )
        description.set(
            """
            """.trimIndent(),
        )
    }
}
