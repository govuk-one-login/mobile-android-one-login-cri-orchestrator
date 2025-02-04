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
        libs.uk.gov.logging.testdouble,
        project(":libraries:di"),
        project(":features:resume:internal-api"),
        project(":features:resume:public-api"),
        testFixtures(project(":libraries:android-utils")),
    ).forEach {
        implementation(it)
    }

    listOf(
        libs.androidx.lifecycle.viewmodel.compose,
        libs.uk.gov.logging.api,
        project(":libraries:android-utils"),
    ).forEach {
        api(it)
    }
}

mavenPublishingConfig {
    mavenConfigBlock {
        name.set(
            "GOV.UK One Login CRI Orchestrator Resume ID Check Card Internal",
        )
        description.set(
            """
            The Resume ID Check Card Internal module contains implementations of UI components and
            their entry points relevant the Resume ID Check Card feature.
            """.trimIndent(),
        )
    }
}
