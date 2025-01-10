package uk.gov.onelogin.criorchestrator

import org.gradle.accessors.dm.LibrariesForLibs

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

listOf(
    libs.plugins.android.library,
    libs.plugins.kotlin.android,
).forEach {
    project.plugins.apply(it.get().pluginId)
}