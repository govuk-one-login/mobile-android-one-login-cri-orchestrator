package uk.gov.onelogin.criorchestrator

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.the
import uk.gov.onelogin.criorchestrator.extensions.JAVA_VERSION
import kotlin.collections.forEach
import kotlin.collections.listOf

//https://github.com/gradle/gradle/issues/15383
val libs = the<LibrariesForLibs>()

listOf(
    "java-library",
    "uk.gov.publishing.config",
    "uk.gov.onelogin.criorchestrator.code-quality-config",
    "uk.gov.onelogin.criorchestrator.publishing-id-config",
).forEach {
    project.plugins.apply(it)
}

listOf(
    libs.plugins.kotlin.jvm
).forEach {
    project.plugins.apply(it.get().pluginId)
}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.toVersion(JAVA_VERSION)
    targetCompatibility = JavaVersion.toVersion(JAVA_VERSION)
}
