package uk.gov.onelogin.criorchestrator

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the
import uk.gov.onelogin.criorchestrator.extensions.androidUiTestDependencies
import uk.gov.onelogin.criorchestrator.extensions.uiDependencies

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

listOf(
    libs.plugins.compose.compiler
).forEach {
    project.plugins.apply(it.get().pluginId)
}

dependencies {
    uiDependencies(libs)
    androidUiTestDependencies(libs)
}