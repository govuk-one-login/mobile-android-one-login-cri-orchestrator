package uk.gov.onelogin.criorchestrator

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the
import uk.gov.onelogin.criorchestrator.extensions.androidUiTestDependencies
import uk.gov.onelogin.criorchestrator.extensions.uiDependencies

listOf(
    "uk.gov.onelogin.criorchestrator.base-compose-config",
    "uk.gov.onelogin.criorchestrator.screenshot-test-config"
).forEach {
    project.plugins.apply(it)
}


//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

dependencies {
    uiDependencies(libs)
    androidUiTestDependencies(libs)
}
