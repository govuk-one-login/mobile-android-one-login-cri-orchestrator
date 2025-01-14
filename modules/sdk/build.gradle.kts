import com.android.build.api.dsl.LibraryExtension
import uk.gov.onelogin.criorchestrator.extensions.setNamespace

plugins {
    id("uk.gov.onelogin.criorchestrator.android-lib-config")
}

configure<LibraryExtension> {
    setNamespace(suffix = ".sdk")
}

dependencies {
    listOf(
        libs.androidx.test.espresso.accessibility,
    ).forEach {
        androidTestImplementation(it)
    }
}

mavenPublishingConfig {
    mavenConfigBlock {
        name.set(
            "GOV.UK One Login CRI Orchestrator SDK",
        )
        description.set(
            """
            Contains logic, screens, interfaces, use cases and implementations core to the CRI Orchestrator.
            """.trimIndent(),
        )
    }
}
