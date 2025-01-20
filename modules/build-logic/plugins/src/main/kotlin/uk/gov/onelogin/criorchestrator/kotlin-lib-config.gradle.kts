package uk.gov.onelogin.criorchestrator

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the
import kotlin.collections.forEach
import kotlin.collections.listOf

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

listOf(
    "java-library",
    "uk.gov.onelogin.criorchestrator.code-quality-config",
).forEach {
    project.plugins.apply(it)
}

listOf(
    libs.plugins.kotlin.jvm
).forEach {
    project.plugins.apply(it.get().pluginId)
}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.toVersion(21)
    targetCompatibility = JavaVersion.toVersion(21)
}
