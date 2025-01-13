import uk.gov.pipelines.emulator.EmulatorConfig
import uk.gov.pipelines.emulator.SystemImageSource

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    id("uk.gov.pipelines.android-root-config")
}

buildscript {
    val buildLogicDir: String by extra("mobile-android-pipelines/buildLogic")
    val sonarProperties: Map<String, String> by extra(
        mapOf(
            "sonar.projectKey" to "mobile-android-cri-orchestrator",
            "sonar.projectId" to "mobile-android-cri-orchestrator",
        )
    )
    dependencies {
        listOf(
            // https://issuetracker.google.com/issues/380600747
            libs.org.bouncycastle.bcutil.jdk18on,
        ).forEach {
            classpath(it)
        }
    }
}

 val emulatorConfig: EmulatorConfig by extra(
    EmulatorConfig(
        systemImageSources = setOf(
            SystemImageSource.AOSP_ATD
        ),
        androidApiLevels = setOf(33),
        deviceFilters = setOf("Pixel XL"),
    )
)
