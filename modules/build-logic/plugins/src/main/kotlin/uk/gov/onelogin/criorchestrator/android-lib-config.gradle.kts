package uk.gov.onelogin.criorchestrator

import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.BaseExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import uk.gov.onelogin.criorchestrator.extensions.androidTestDependencies
import uk.gov.onelogin.criorchestrator.extensions.setJavaVersion
import uk.gov.onelogin.criorchestrator.extensions.testDependencies
import uk.gov.pipelines.extensions.BaseExtensions.baseAndroidConfig
import uk.gov.pipelines.extensions.LintExtensions.configureLintOptions

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

listOf(
    "com.android.library",
    "org.jetbrains.kotlin.android",
    "uk.gov.pipelines.detekt-config",
    "uk.gov.pipelines.emulator-config",
    "uk.gov.pipelines.jacoco-lib-config",
    "uk.gov.pipelines.jvm-toolchains",
    "uk.gov.pipelines.ktlint-config",
    "uk.gov.pipelines.sonarqube-module-config",
    "uk.gov.publishing.config",
    "uk.gov.onelogin.criorchestrator.di-config",
    "uk.gov.onelogin.criorchestrator.unit-test-config",
).forEach {
    project.plugins.apply(it)
}

configure<BaseExtension> {
    baseAndroidConfig(project)
}

configure<LibraryExtension> {
    lint(configureLintOptions("${rootProject.projectDir}/config"))
}

configure<LibraryExtension> {
    setJavaVersion()
}

configure<KotlinAndroidProjectExtension> {
    setJavaVersion()
}

dependencies {
    androidTestDependencies(libs)
    testDependencies(libs)
}
